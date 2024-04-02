package Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import sandbox.*;

import javax.xml.crypto.Data;

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
  public void testGetDiscount()
  {

    Discount discount = Database.getDiscount("9780241341650");

    assertEquals(20,discount.discount);
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
  public void testGetAllRequests()
  {
    List<ItemRequest> itemRequests = Database.getAllRequests();
    assertFalse(itemRequests.isEmpty());
    for (ItemRequest request : itemRequests) {
      assertNotNull(request);
    }
  }

  @Test
  public void testGetAllUsersMap()
  {
    Map<String, String> usersMap = Database.getAllUsersMap();
    assertFalse(usersMap.isEmpty());

    for (Map.Entry<String, String> entry : usersMap.entrySet()) {
      String email = entry.getKey();
      String password = entry.getValue();

      assertNotNull(email);
      assertNotNull(password);

      // You can add more specific assertions here based on your requirements
    }
  }

  @Test
  public void testGetUser()
  {
    User user = Database.getUser("325c96");
    assertNotNull(user); // Assert that the user object is not null

    // Add more specific assertions based on the attributes of the User object
    assertEquals("325c96", user.id);
    assertEquals("Student", user.name);
    assertEquals("student@yorku.ca",user.email);
    assertEquals("Student", user.type);
    assertEquals(true,user.isVerified);

    // Add more assertions based on other attributes as needed
  }

  @Test
  public void testGetInvalidUser()
  {
    User user = Database.getUser("11111");
    assertNull(user);
  }

  @Test
  public void testGetUserByEmail()
  {
    User user = Database.getUserByEmail("student@yorku.ca");
    assertNotNull(user); // Assert that the user object is not null

    // Add more specific assertions based on the attributes of the User object
    assertEquals("325c96", user.id);
    assertEquals("Student", user.name);
    assertEquals("student@yorku.ca",user.email);
    assertEquals("Student", user.type);
    assertEquals(true,user.isVerified);
  }

  @Test
  public void testGetInvalidUserByEmail()
  {
    User user = Database.getUserByEmail("wrong@yorku.ca");
    assertNull(user);
  }

  @Test
  public void testGetNewsletters()
  {
    List<Newsletter> newsletters = Database.getNewsletters();
    assertFalse(newsletters.isEmpty());
    for (Newsletter newsletter : newsletters) {
      assertNotNull(newsletter);
    }
  }

  @Test
  public void testGetUserSubscription()
  {
    List<Newsletter> subscriptions = Database.getUserSubscription("6fd709");

    assertNotNull(subscriptions); // Assert that the subscriptions list is not null

    // Add more specific assertions based on the content of the subscriptions list
    assertFalse(subscriptions.isEmpty());
  }

  @Test
  public void testGetNews()
  {
    Newsletter expected = new  NewsletterProxy();
    expected.fee =10.0;
    expected.name = "NY-Times";
    expected.id = "72c09";
    expected.url = "https://www.nytimes.com/ca/";
    Newsletter newsletter = Database.getNews();
    assertNotNull(newsletter);
    assertEquals(expected.fee,newsletter.fee);
    assertEquals(expected.name,newsletter.name);
    assertEquals(expected.id,newsletter.id);
    assertEquals(expected.url,newsletter.url);
  }

  @Test
  public void testGetInvalidNews() {}

  @Test
  public void testGetTextbook()
  {
    Textbook actual  = Database.getTextbook("9780201633610");
    assertNotNull(actual);
    assertEquals("9780201633610", actual.id);
    assertEquals("5b16a4c2", actual.groupID);
    assertEquals(1,actual.edition);
  }

  @Test
  public void testGetInvalidTextbook()
  {
    Textbook actual  = Database.getTextbook("00000");
    assertNull(actual);
  }

  @Test
  public void testGetTextbooksByGroup()
  {
    List<Textbook> textbooks = Database.getTextbooksByGroup("5b16a4c2");
    assertFalse(textbooks.isEmpty());
    for (Textbook text : textbooks) {
      assertNotNull(text);
    }
  }

  @Test
  public void testGetInvalidTextbooksByGroup()
  {
    List<Textbook> textbooks = Database.getTextbooksByGroup("0000");
    assertTrue(textbooks.isEmpty());
  }

  @Test
  public void testUpdateUserVerification()
  {
    User user = Database.getUser("325c96");
    Database.updateUserVerification("325c96",true);
    assertEquals(true,user.isVerified);

  }

  @Test
  public void testUpdateInvalidUserVerification() {}

  @Test
  public void testUpdateItemCopiesInc()
  {
    Item item = Database.getItem("9780241341650");
    if(item.copies!=19) {
      Database.updateItemCopies("9780241341650", 0);
       item = Database.getItem("9780241341650");
    }
    assertEquals(19,item.copies);
  }

  @Test
  public void testUpdateItemCopiesDec() {

    Item item = Database.getItem("9780241341650");
    if (item.copies != 19) {
      Database.updateItemCopies("9780241341650", -1);
      item = Database.getItem("9780241341650");
    }

    assertEquals(19,item.copies);
  }

  @Test
  public void testUpdateInvalidItemCopies() {}

  @Test
  public void testUpdateItemPermissionDisable()
  {
    Database.updateItemPermission("9780241341650", ItemPermission.Disabled);
    Item item = Database.getItem("9780241341650");
    assertEquals(ItemPermission.Disabled,item.permission);
  }

  @Test
  public void testUpdateItemPermissionEnable()
  {
    Database.updateItemPermission("9780241341650", ItemPermission.Rentable);
    Item item = Database.getItem("9780241341650");
    assertEquals(ItemPermission.Rentable,item.permission);
  }

  @Test
  public void testUpdateInvalidItemPermission() {}

  @Test
  public void testDeleteItem()
  {
    Database.deleteItem("dacda374-6404-432f");
    Item item = Database.getItem("dacda374-6404-432f");
    assertNull(item);
  }

  @Test
  public void testDeleteInvalidItem() {}

  @Test
  public void testDeleteRental()
  {
    Database.deleteRental("05c83467-739a-450e","111");
    List<RentedItem> rentals = Database.getUserRentals("111");
    assertTrue(rentals.isEmpty());
  }

  @Test
  public void testDeleteInvalidRental() {}
}
