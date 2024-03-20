package sandbox;

import java.time.LocalDate;

public class RentedItem {
  private final Item item;
  private final String userID;
  private final LocalDate dueDate;
  private final boolean isLost;

  public RentedItem(Item item, String userID, LocalDate dueDate) {
    this.item = item;
    this.userID = userID;
    this.dueDate = dueDate;
    this.isLost = dueDate.plusDays(15).isBefore(LocalDate.now());
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

  public boolean isLost() {
    return isLost;
  }
}
