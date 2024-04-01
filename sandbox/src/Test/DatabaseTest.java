package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import sandbox.*;

public class DatabaseTest {
  private final Database db = Database.getInstance();

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

  @Test
  public void testInsertRequest() {
    int size = db.getAllRequests().size();
    ItemRequest request = new ItemRequest("test", ItemType.Textbook, "0", "test", "");
    db.insertRequest(request);
    assertEquals(size + 1, db.getAllRequests().size());
  }

  @Test
  public void testInsertSubscription() {
    String userID = "d165df";
    Database.insertSubscription("72c09", userID);
    List<Newsletter> list = Database.getUserSubscription(userID);
    assertFalse(list.isEmpty());
    assertEquals("72c09", list.get(list.size() - 1).id);
  }

  @Test
  public void testGetAllCourses() {
    List<Course> courses = db.getAllCourses();
    assertFalse(courses.isEmpty());
    for (Course course : courses) {
       assertNotNull(course);
    }
  }

  @Test
  public void testGetCourse() {
    String courseID = "443e7f84";
    Course course = db.getCourse(courseID);
    assertNotNull(course);
    assertEquals(courseID, course.getId());
    assertEquals("EECS3311", course.getName());
    assertEquals("M", course.getSection());
    assertEquals("W24", course.getTerm());
    assertNotNull(course.getTextbook());
    assertEquals("9780201633610nline", course.getTextbook().id);
  }

  @Test
  public void testGetInvalidCourse() {
    String courseID = "N/A";
    Course course = db.getCourse(courseID);
    assertNull(course);
  }

  @Test
  public void testGetFacultyCourses() {}

  @Test
  public void testGetStudentCourses() {}

  @Test
  public void testGetAllItems() {}

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
  public void testGetDiscount() {}

  @Test
  public void testGetUserRentals() {
    List<RentedItem> rentedItems = Database.getUserRentals("325c96");
    assertFalse(rentedItems.isEmpty());
    for (RentedItem item : rentedItems) {
      assertEquals("325c96", item.getUserID());
    }
  }

  @Test
  public void testGetAllRequests() {}

  @Test
  public void testGetAllUsersMap() {}

  @Test
  public void testGetUser() {}

  @Test
  public void testGetInvalidUser() {}

  @Test
  public void testGetUserByEmail() {}

  @Test
  public void testGetInvalidUserByEmail() {}

  @Test
  public void testGetNewsletters() {}

  @Test
  public void testGetUserSubscription() {}

  @Test
  public void testGetNews() {}

  @Test
  public void testGetInvalidNews() {}

  @Test
  public void testGetTextbook() {}

  @Test
  public void testGetInvalidTextbook() {}

  @Test
  public void testGetTextbooksByGroup() {}

  @Test
  public void testGetInvalidTextbooksByGroup() {}

  @Test
  public void testUpdateUserVerification() {}

  @Test
  public void testUpdateInvalidUserVerification() {}

  @Test
  public void testUpdateItemCopiesInc() {}

  @Test
  public void testUpdateItemCopiesDec() {}

  @Test
  public void testUpdateInvalidItemCopies() {}

  @Test
  public void testUpdateItemPermissionDisable() {}

  @Test
  public void testUpdateItemPermissionEnable() {}

  @Test
  public void testUpdateInvalidItemPermission() {}

  @Test
  public void testDeleteItem() {}

  @Test
  public void testDeleteInvalidItem() {}

  @Test
  public void testDeleteRental() {}

  @Test
  public void testDeleteInvalidRental() {}
}
