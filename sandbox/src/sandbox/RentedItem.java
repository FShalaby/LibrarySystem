package sandbox;

import java.time.LocalDate;

public class RentedItem {
  public static final int MAX_RENTAL_DAYS = 30;
  private final Item item;
  private final String userID;
  private final LocalDate dueDate;

  public RentedItem(Item item, String userID, LocalDate dueDate) {
    this.item = item;
    this.userID = userID;
    this.dueDate = dueDate;
  }

  public Item getItem() {
    return item;
  }

  public String getUserID() {
    return userID;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }
}
