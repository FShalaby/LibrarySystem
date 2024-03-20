package sandbox;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public abstract class User {
  public String name;
  public String email;
  public String id;
  public String type;
  protected String pw;
  public boolean isVerified;
  protected int limit = 0;
  protected int overdue = 0;
  protected double penalty = 0.0;
  private List<RentedItem> rentedItems = new ArrayList<>();
  public HashMap<Newsletter, Boolean> subscriptions;

  // Generate random ID()
  protected static String generateRandomID() {
    // Generate a random UUID
    UUID uuid = UUID.randomUUID();
    // Convert UUID to string, remove hyphens, and get the first 6 characters
    return uuid.toString().replaceAll("-", "").substring(0, 6);
  }

  // write on the CSV
  // ===============================

  public synchronized void writeUserCsv() {
    Database.getInstance()
        .insertUser(this.name, this.id, this.email, this.pw, this.type, this.isVerified);
  }

  public double getPenalty() {
    return penalty;
  }

  public int getLimit() {
    return limit;
  }

  public int getOverdue() {
    return overdue;
  }

  public List<RentedItem> getRentedItems() {
    return rentedItems;
  }

  public void addRentedItem(RentedItem item) {
    this.rentedItems.add(item);

    // count physical items
    if (!item.getItem().location.equalsIgnoreCase("online")) {
      limit++;
    }
  }

  public void setRentedItems(List<RentedItem> rentedItems) {
    this.rentedItems = rentedItems;
    limit = 0;
    overdue = 0;
    penalty = 0;

    for (RentedItem rental : rentedItems) {
      // count physical items
      if (!rental.getItem().location.equalsIgnoreCase("online")) {
        limit++;
      }

      if (rental.getDueDate().isBefore(LocalDate.now())) {
        overdue++;
        penalty += LocalDate.now().compareTo(rental.getDueDate()) * 0.5;
      }
    }
  }
}
