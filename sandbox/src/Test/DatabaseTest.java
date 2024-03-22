package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import sandbox.*;

public class DatabaseTest {
  private final Database db = Database.getInstance();

  @Test
  public void testGetItem() {
    Item item = Database.getItem("9780201633610");
    assertNotNull(item);
    assertEquals("9780201633610", item.id);
    assertEquals("Design Patterns: Elements of Reusable Object-Oriented Software", item.name);
    assertEquals("Scott Library", item.location);
  }

  @Test
  public void testGetInvalidItem() {
    Item item = Database.getItem("N/A");
    assertNull(item);
  }

  @Test
  public void testInsertItem() {
    Item item =
        new Item(
            "test1234",
            "test1234",
            "online",
            ItemType.Book,
            0.00,
            ItemStatus.Available,
            ItemPermission.RentableAndPurchasable,
            "test",
            20);

    Database.insertItem(item);
  }

  @Test
  public void testGetUserRentals() {
    List<RentedItem> rentedItems = Database.getUserRentals("325c96");
    assertEquals(5, rentedItems.size());
    for (RentedItem item : rentedItems) {
      assertEquals("325c96", item.getUserID());
      assertNotNull(item.getItem());
    }
  }

  @Test
  public void testInsertRental() {
    String itemID = "test1234";
    String userID = "325c96";
    Database.insertRental(itemID, userID);

    List<RentedItem> rentedItems = Database.getUserRentals(userID);
    RentedItem item = rentedItems.get(rentedItems.size() - 1);
    assertEquals(userID, item.getUserID());
    assertNotNull(item.getItem());
    assertEquals(itemID, item.getItem().id);
    assertEquals(LocalDate.now().plusDays(30), item.getDueDate());
  }

  @Test
  public void testInsertRentalCustomDate() {
    String itemID = "test1234";
    String userID = "325c96";
    db.insertRental(itemID, userID, LocalDate.now().plusDays(1));

    List<RentedItem> rentedItems = Database.getUserRentals(userID);
    RentedItem item = rentedItems.get(rentedItems.size() - 1);
    assertEquals(LocalDate.now().plusDays(1), item.getDueDate());
  }
}
