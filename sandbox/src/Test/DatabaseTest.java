package Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import sandbox.*;

public class DatabaseTest {
  private final Database db = Database.getInstance();

  @Test
  public void testInsertDeleteItem() {
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

    Item dbItem = Database.getItem("test1234");
    assertNotNull(dbItem);
    assertEquals("test1234", dbItem.id);
    assertEquals("test1234", dbItem.name);
    assertEquals(ItemType.Book, dbItem.type);
    assertEquals(0.00, dbItem.price, 0.01);
    assertEquals(ItemStatus.Available, dbItem.status);
    assertEquals(ItemPermission.RentableAndPurchasable, dbItem.permission);
    assertEquals("test", dbItem.category);
    assertEquals(20, dbItem.copies);

    Database.deleteItem("test1234");
    assertNull(Database.getItem("test1234"));
  }

  @Test
  public void testInsertDeleteRental() {
    String itemID = "9780201633610";
    String userID = "t1";
    Database.insertRental(itemID, userID);

    List<RentedItem> rentedItems = Database.getUserRentals(userID);
    RentedItem item = rentedItems.get(rentedItems.size() - 1);
    assertEquals(userID, item.getUserID());
    assertNotNull(item.getItem());
    assertEquals(itemID, item.getItem().id);
    assertEquals(LocalDate.now().plusDays(30), item.getDueDate());

    int size = Database.getUserRentals(userID).size();
    Database.deleteRental(itemID, userID);
    assertEquals(size - 1, Database.getUserRentals(userID).size());
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
    int size = Database.getAllRequests().size();
    ItemRequest request = new ItemRequest("test", ItemType.Textbook, "0", "test", "");
    db.insertRequest(request);
    assertEquals(size + 1, Database.getAllRequests().size());
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
  public void testInsertUser() {
    db.insertUser("test", "test1234", "test@yorku.ca", "1234", "student", false);
    User user = Database.getUser("test1234");
    assertNotNull(user);
    assertEquals("test", user.name);
    assertEquals("test1234", user.id);
    assertEquals("test@yorku.ca", user.email);
    assertInstanceOf(Student.class, user);
    assertFalse(user.isVerified);
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
  public void testGetFacultyCourses() {
    String facultyID = "6fd709";
    List<Course> courses = db.getFacultyCourses(facultyID);
    assertFalse(courses.isEmpty());
    for (Course course : courses) {
      assertNotNull(course);
      assertEquals(facultyID, course.getFaculty().id);
    }
  }

  @Test
  public void testGetInvalidFacultyCourses() {
    String facultyID = "N/A";
    List<Course> courses = db.getFacultyCourses(facultyID);
    assertTrue(courses.isEmpty());
  }

  @Test
  public void testGetStudentCourses() {
    String studentID = "325c96";
    List<Course> courses = db.getStudentCourses(studentID);
    assertFalse(courses.isEmpty());
    for (Course course : courses) {
      assertNotNull(course);
    }
  }

  @Test
  public void testGetInvalidStudentCourses() {
    String studentID = "N/A";
    List<Course> courses = db.getStudentCourses(studentID);
    assertTrue(courses.isEmpty());
  }

  @Test
  public void testGetAllItems() {
    List<Item> items = db.getAllItems();
    assertFalse(items.isEmpty());
    for (Item item : items) {
      assertNotNull(item);
    }
  }

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
  public void testGetDiscount() {
    Discount discount = Database.getDiscount("9780241341650");
    assertNotNull(discount);
    assertEquals("9780241341650", discount.item_id);
    assertEquals("promo1", discount.code);
    assertEquals(20, discount.discount);
  }

  @Test
  public void testGetInvalidDiscount() {
    Discount discount = Database.getDiscount("N/A");
    assertNull(discount);
  }

  @Test
  public void testGetUserRentals() {
    List<RentedItem> rentedItems = Database.getUserRentals("325c96");
    assertFalse(rentedItems.isEmpty());
    for (RentedItem item : rentedItems) {
      assertEquals("325c96", item.getUserID());
    }
  }

  @Test
  public void testGetAllRequests() {
    List<ItemRequest> requests = Database.getAllRequests();
    assertFalse(requests.isEmpty());
    for (ItemRequest request : requests) {
      assertNotNull(request);
      assertEquals(ItemType.Textbook, request.getItemType());
      assertTrue(request.getPriority() == 0 || request.getPriority() == 1);
    }
  }

  @Test
  public void testGetAllUsersMap() {
    Map<String, String> usersMap = Database.getAllUsersMap();
    assertFalse(usersMap.isEmpty());
    for (String email : usersMap.keySet()) {
      User user = Database.getUserByEmail(email);
      assertNotNull(user);
    }
  }

  @Test
  public void testGetUser() {
    String id = "325c96";
    User user = Database.getUser(id);
    assertNotNull(user);
    assertEquals(id, user.id);
    assertInstanceOf(Student.class, user);
  }

  @Test
  public void testGetInvalidUser() {
    String id = "N/A";
    User user = Database.getUser(id);
    assertNull(user);
  }

  @Test
  public void testGetUserByEmail() {
    String id = "325c96";
    String email = "student@yorku.ca";
    User user = Database.getUserByEmail(email);
    assertNotNull(user);
    assertEquals(id, user.id);
    assertInstanceOf(Student.class, user);
  }

  @Test
  public void testGetInvalidUserByEmail() {
    String email = "N/A";
    User user = Database.getUserByEmail(email);
    assertNull(user);
  }

  @Test
  public void testGetNewsletters() {
    List<Newsletter> newsletters = Database.getNewsletters();
    assertFalse(newsletters.isEmpty());
    for (Newsletter newsletter : newsletters) {
      assertNotNull(newsletter);
    }
  }

  @Test
  public void testGetUserSubscription() {
    List<Newsletter> newsletters = Database.getUserSubscription("6fd709");
    assertFalse(newsletters.isEmpty());
    for (Newsletter newsletter : newsletters) {
      assertNotNull(newsletter);
    }
  }

  @Test
  public void testGetNews() {
    Newsletter newsletter = Database.getNews();
    assertNotNull(newsletter);

    double expectedFee = 10.0;
    String expectedName = "NY-Times";
    String expectedId = "72c09";
    String expectedUrl = "https://www.nytimes.com/ca/";

    assertEquals(expectedFee, newsletter.fee, 0.01);
    assertEquals(expectedName, newsletter.name);
    assertEquals(expectedId, newsletter.id);
    assertEquals(expectedUrl, newsletter.url);
  }

  @Test
  public void testGetTextbook() {
    Textbook textbook = Database.getTextbook("9780201633610nline");
    assertNotNull(textbook);
    assertEquals("9780201633610nline", textbook.id);
    assertEquals("online", textbook.location);
  }

  @Test
  public void testGetInvalidTextbook() {
    Textbook textbook = Database.getTextbook("N/A");
    assertNull(textbook);
  }

  @Test
  public void testGetTextbooksByGroup() {
    List<Textbook> textbooks = Database.getTextbooksByGroup("5616a4c2");
    assertFalse(textbooks.isEmpty());
    for (Textbook textbook : textbooks) {
      assertNotNull(textbook);
    }
  }

  @Test
  public void testGetTextbooksByInvalidGroup() {
    List<Textbook> textbooks = Database.getTextbooksByGroup("N/A");
    assertTrue(textbooks.isEmpty());
  }

  @Test
  public void testUpdateUserVerification() {
    Database.updateUserVerification("t1", true);
    User user = Database.getUser("t1");
    assertNotNull(user);
    assertTrue(user.isVerified);

    Database.updateUserVerification("t1", false);
    user = Database.getUser("t1");
    assertNotNull(user);
    assertFalse(user.isVerified);
  }

  @Test
  public void testUpdateItemCopies() {
    String itemID = "9780201633610";
    int copies = Objects.requireNonNull(Database.getItem(itemID)).copies;
    Database.updateItemCopies(itemID, 1);
    assertEquals(copies + 1, Objects.requireNonNull(Database.getItem(itemID)).copies);

    Database.updateItemCopies(itemID, -1);
    assertEquals(copies, Objects.requireNonNull(Database.getItem(itemID)).copies);
  }

  @Test
  public void testUpdateItemPermission() {
    String itemID = "9780201633610";
    ItemPermission permission = Objects.requireNonNull(Database.getItem(itemID)).permission;
    assertEquals(ItemPermission.Rentable, permission);

    Database.updateItemPermission(itemID, ItemPermission.Disabled);
    permission = Objects.requireNonNull(Database.getItem(itemID)).permission;
    assertEquals(ItemPermission.Disabled, permission);

    // re-enable
    permission = Objects.requireNonNull(Database.getItem(itemID)).permission;
    assertEquals(ItemPermission.Disabled, permission);

    Database.updateItemPermission(itemID, ItemPermission.Rentable);
    permission = Objects.requireNonNull(Database.getItem(itemID)).permission;
    assertEquals(ItemPermission.Rentable, permission);
  }
}
