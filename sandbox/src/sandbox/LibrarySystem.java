package sandbox;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LibrarySystem {
  private static final Database db = Database.getInstance();
  public Item item;
  public User user;
  public Newsletter newsletter;
  public static HashMap<String, Integer> inventory = new HashMap<>();
  public static HashMap<String, String> genre = new HashMap<>();
  public static HashMap<String, Item> itemMap = new HashMap<>();
  //    public List<Item> recommendations = new ArrayList<Item>();
  public double penalty = 0.5;
  public Payment payment;

  public String RentItem(Item item, User user) {
    // check last permission bit (renting bit)
    if (user.limit >= 10
        || ((item.permission.getValue() & 1) != 1)
        || item.copies <= 0
        || user.overdue >= 3) {
      return "Sorry, item " + item.name + " cannot be rented";
    }

    item.status = ItemStatus.Rented;
    user.addRentedItem(new RentedItem(item, user.id, LocalDate.now().plusDays(30)));
    inventory.put(item.name, item.copies - 1);
    Database.updateItemCopies(item.id, -1);

    LocalDate currentDate = LocalDate.now();
    LocalDate dueDate = currentDate.plusDays(30);
    item.dueDate = dueDate;

    // Check for overdue
    LocalDate today = LocalDate.now();
    if (today.isAfter(dueDate)) {
      long overdueDays = today.toEpochDay() - dueDate.toEpochDay();

      // Calculate overdue fee
      double fine = overdueDays * penalty;
      user.overdue = user.overdue + 1;
      return "Item " + item.name + " rented successfully. Overdue fee: $" + fine;
    }

    Database.insertRental(item.id, user.id);
    return "Item " + item.name + " rented successfully.";
  }

  public Item searchItem(String name) {
    String lowercaseName = name.toLowerCase(); // Convert search query to lowercase
    List<Item> items = db.getAllItems();

    Item item = null;
    for (Item i : items) {
      // prioritize exact match
      if (Objects.equals(lowercaseName, i.name.toLowerCase())) {
        return i;
      }

      // if not exact match, find first item whose name is close enough
      if (item == null && i.name.toLowerCase().contains(lowercaseName)) {
        item = i;
      }
    }

    return item;
  }

  public Newsletter searchNews(String name) {
    String lowercaseName = name.toLowerCase(); // Convert search query to lowercase
    List<Newsletter> news = db.getNewsletters();

    // first check inventory
    for (String newsName : inventory.keySet()) {
      String lowercaseItemName = newsletter.name.toLowerCase(); // Convert item name to lowercase
      if (lowercaseItemName.equals(lowercaseName)) {
        return newsletter; // Return the item if found
      }
    }

    Newsletter n = null;
    // check db if inventory does not have item
    for (Newsletter i : news) {
      // prioritize exact match
      if (Objects.equals(lowercaseName, i.name.toLowerCase())) {
        return i;
      }

      // if not exact match, find first item whose name is close enough
      if (n == null && i.name.toLowerCase().contains(lowercaseName)) {
        n = i;
      }
    }

    return n;
  }

  public List<Item> getRecommendations(String category) {
    CategoryStrategy categoryStrategy = new CategoryStrategy();
    return categoryStrategy.search(category);
  }

  public String BuyItem(Item item, Payment payment, User user, double discountedPrice) {
    // check first permission bit (purchasing)
    if ((((item.permission.getValue() >> 1) & 1) == 1) && item.copies > 0) {
      // Process the payment with the discounted price
      boolean paymentProcessed;
      if (discountedPrice != 0) {
        paymentProcessed = payment.processPayment(discountedPrice);
      } else {
        // Process the payment with the original price if discounted price is zero
        paymentProcessed = payment.processPayment(item.price);
      }

      if (paymentProcessed) {
        item.status = ItemStatus.Purchased;
        inventory.put(item.name, item.copies - 1);
        Database.updateItemCopies(item.id, -1);
        return "Item " + item.name + " purchased successfully.";
      } else {
        return "Payment processing failed for item " + item.name + ".";
      }
    }

    return "Sorry, item " + item.name + " cannot be purchased";
  }

  public void createVirtualCopy(String itemID) {
    db.updateItemCopies(itemID, 1);
  }

  public void removeVirtualCopy(String itemID) {
    db.updateItemCopies(itemID, -1);
  }

  public static List<RentedItem> displayRentedBooks(User user) {
    return user.getRentedItems();
  }

  public HashMap<String, Integer> getInventory() {
    // TODO Auto-generated method stub
    return inventory;
  }

  public static HashMap<String, Item> getItemMap() {

    return itemMap;
  }

  public static String submitItemRequest(ItemRequest request) {
    for (ItemRequest req : db.getAllRequests()) {
      if (req.getItemID().equalsIgnoreCase(request.getItemID())) {
        return "Item already requested.";
      }
    }

    db.insertRequest(request);
    List<ItemRequest> allRequests = db.getAllRequests();
    for (int i = 0; i < allRequests.size(); i++) {
      if (allRequests.get(i).getItemID().equalsIgnoreCase(request.getItemID())) {
        return "Request successful, your request is at position "
            + (i + 1)
            + " (of "
            + allRequests.size()
            + ")";
      }
    }

    return "NOT FOUND";
  }

  public static Textbook getLatestTextbook(Course course) {
    List<Textbook> textbooksByGroup = db.getTextbooksByGroup(course.getTextbook().groupID);
    return textbooksByGroup.get(0);
  }

  public static String checkUnavailableNewTextbooks() {
    StringBuilder builder = new StringBuilder();
    List<Course> courses = db.getAllCourses();
    for (Course c : courses) {
      if (c.getEndDate().isBefore(LocalDate.now())) continue;

      Textbook latest = getLatestTextbook(c);

      // newer version exists but not available
      if (latest.id == null || latest.id.isEmpty()) {
        builder
            .append("Newer edition of ")
            .append(c.getTextbook().name)
            .append(" exists for ")
            .append(c.getName())
            .append(" but is not yet available at the library.\n");
      }
    }

    return builder.toString();
  }

  public String toString() {
    return "Name: "
        + item.name
        + "\n"
        + "Category: "
        + item.category
        + "\n"
        + "Location: "
        + item.location
        + "\n"
        + "Permission: "
        + item.permission
        + "\n"
        + "Price: "
        + item.price
        + "\n"
        + "Inventory: "
        + item.copies
        + "\n";
  }
}
