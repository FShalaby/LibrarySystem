package sandbox;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class Database {
  private static Database dbInstance;

  private Database() {}

  public static Database getInstance() {
    if (dbInstance == null) {
      dbInstance = new Database();
    }

    return dbInstance;
  }

  // create methods

  /**
   * Inserts a new row into items.csv.
   *
   * @param item The item to add
   */
  public static void insertItem(Item item) {

    String filename = getItemsCsvFilename();

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
      writer.newLine();
      writer.write(
          String.format(
              "%s,%s,%s,%d,%.2f,%d,%d,%s,%d",
              item.id,
              item.name,
              item.location,
              item.type.getValue(),
              item.price,
              item.status.getValue(),
              item.permission.getValue(),
              item.category,
              item.copies));
      writer.close();

      System.out.println("Item data has been written to the CSV file.");
    } catch (IOException ex) {
      System.err.println(ex.getMessage());
    }
  }

  /**
   * Inserts a new row into rentals.csv.
   *
   * @param itemID The ID of the rented item
   * @param userID The ID of the renter
   * @param dueDate The due date of the rented item
   */
  public void insertRental(String itemID, String userID, LocalDate dueDate) {
    String filename = getRentalsCsvFilename();

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
      writer.write(String.format("%s,%s,%s", itemID, userID, dueDate));
      writer.newLine();
      writer.close();

      System.out.println("Rental data has been written to the CSV file.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  /**
   * Inserts a new row into rentals.csv, due date is automatically calculated (now + 1 month).
   *
   * @param itemID The ID of the rented item
   * @param userID The ID of the renter
   */
  public static void insertRental(String itemID, String userID) {
    String filename = getRentalsCsvFilename();

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
      writer.write(String.format("%s,%s,%s", itemID, userID, LocalDate.now().plusMonths(1)));
      writer.newLine();
      writer.close();

      System.out.println("Rental data has been written to the CSV file.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  /**
   * Inserts a new row into requests.csv.
   *
   * @param request The ItemRequest to insert
   */
  public void insertRequest(ItemRequest request) {
    String filename = getRequestsCsvFilename();

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
      writer.write(
          String.format(
              "%s,%s,%s,%s,%s,%s,%s",
              request.getItemName(),
              request.getItemType(),
              request.getItemID(),
              request.getReason(),
              request.getAdditionalInfo(),
              request.getPriority(),
              request.getRequestDate()));
      writer.newLine();
      writer.close();

      System.out.println("Request data has been written to the CSV file.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  public static void insertSubscription(String newsID, String userID) {
    String filename = getSubscribersCsvFilename();

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
      writer.write(String.format("%s,%s,%s", newsID, userID, LocalDate.now().plusMonths(1)));
      writer.newLine();
      writer.close();

      System.out.println("Rental data has been written to the CSV file.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  /** Inserts a new row into the users.csv table */
  public void insertUser(
      String name, String id, String email, String pass, String type, boolean verified) {
    String filename = getUsersCsvFilename();

    // prevent duplicate emails
    if (getUserByEmail(email) != null) {
      System.err.println("User with email '" + email + "' already exists");
      return;
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
      // Append user data to the CSV file
      writer.write(
          String.format(
              "%s,%s,%s,%s,%s,%s",
              name, id, email, pass, type, verified)); // Assuming ID is the second column
      writer.newLine();
      System.out.println("User data has been written to the CSV file.");
    } catch (IOException ex) {
      System.err.println(ex.getMessage());
    }
  }

  // read methods

  /**
   * Reads the courses.csv file and returns a list containing all courses.
   *
   * @return courses
   */
  public List<Course> getAllCourses() {
    String filename = getCoursesCsvFilename();

    ArrayList<Course> courses = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // ignore first line
        if (line.startsWith("id,") || line.isEmpty()) {
          continue;
        }

        courses.add(courseFromCsvLine(line));
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return courses;
  }

  /**
   * Reads the courses.csv file and returns a course based on the specified ID.
   *
   * @param id The course id
   * @return Course with given id (or null)
   */
  public Course getCourse(String id) {
    String filename = getCoursesCsvFilename();

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // ignore first line
        if (line.startsWith("id,") || line.isEmpty()) {
          continue;
        }

        Course course = courseFromCsvLine(line);
        if (Objects.equals(course.getId(), id)) {
          return course;
        }
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return null;
  }

  /**
   * Reads the courses.csv file and returns a list containing all courses taught by a given faculty
   * member.
   *
   * @param facultyID The Faculty Member's ID
   * @return courses
   */
  public List<Course> getFacultyCourses(String facultyID) {
    String filename = getCoursesCsvFilename();

    ArrayList<Course> courses = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // ignore first line
        if (line.startsWith("id,") || line.isEmpty()) {
          continue;
        }

        Course course = courseFromCsvLine(line);
        if (Objects.equals(course.getFaculty().id, facultyID)) {
          courses.add(course);
        }
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return courses;
  }

  /**
   * Reads the students.csv file and returns a list containing all courses that a student has
   * enrolled in.
   *
   * @param studentID The Student's ID
   * @return courses
   */
  public List<Course> getStudentCourses(String studentID) {
    String filename = getStudentsCsvFilename();

    ArrayList<Course> courses = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // ignore first line
        if (line.startsWith("course_id,") || line.isEmpty()) {
          continue;
        }

        String[] parts = line.split(",");
        if (parts[1].equals(studentID)) {
          courses.add(getCourse(parts[0]));
        }
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return courses;
  }

  /**
   * Reads the items.csv file and returns a list containing all items.
   *
   * @return items
   */
  public List<Item> getAllItems() {
    String filename = getItemsCsvFilename();

    ArrayList<Item> items = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // ignore first line
        if (line.startsWith("id,") || line.isEmpty()) {
          continue;
        }

        items.add(itemFromCsvLine(line));
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return items;
  }

  /**
   * Reads the items.csv file and returns an Item with the given ID.
   *
   * @param id The item's ID
   * @return The item (if found), or <code>null</code>
   */
  public static Item getItem(String id) {
    String filename = getItemsCsvFilename();

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.startsWith("id,")) continue;

        Item item = itemFromCsvLine(line);
        if (Objects.equals(item.id, id)) {
          return item;
        }
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return null;
  }

  public static Discount getDiscount(String id) {
    String filename = getDiscountsCsvFilename();

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.startsWith("item_id,")) continue;

        Discount discount = discountFromCsvLine(line);
        if (Objects.equals(discount.item_id, id)) {
          return discount;
        }
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return null;
  }

  /**
   * Reads the rentals.csv file and returns a list containing all rentals.
   *
   * @return A list of maps containing the user's id as the key, and the rented item (<code>Item
   *     </code>) as the value.
   */
  public static List<RentedItem> getAllRentals() {
    String filename = getRentalsCsvFilename();

    ArrayList<RentedItem> rentals = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // ignore first line
        if (line.startsWith("item_id,")) {
          continue;
        }

        String[] parts = line.split(",");
        Item rented = getItem(parts[0]);
        LocalDate dueDate = LocalDate.parse(parts[2]);

        RentedItem rental = new RentedItem(rented, parts[1], dueDate);
        rentals.add(rental);
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return rentals;
  }

  /**
   * Reads the rentals.csv file and returns a list containing items rented by a given user.
   *
   * @param id The renter's ID
   * @return A list of the user's rented items (<code>Item</code>)
   */
  public static List<RentedItem> getUserRentals(String id) {
    String filename = getRentalsCsvFilename();

    ArrayList<RentedItem> rentals = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // ignore first line
        if (line.startsWith("item_id,") || line.isEmpty()) {
          continue;
        }

        String[] parts = line.split(",");
        if (!Objects.equals(parts[1], id)) continue;

        Item rented = getItem(parts[0]);
        LocalDate dueDate = LocalDate.parse(parts[2]);
        rentals.add(new RentedItem(rented, id, dueDate));
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return rentals;
  }

  /** TODO */
  public List<ItemRequest> getAllRequests() {
    String filename = getRequestsCsvFilename();

    ArrayList<ItemRequest> rentals = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // ignore first line
        if (line.startsWith("item_name,") || line.isEmpty()) {
          continue;
        }

        rentals.add(requestFromCsvLine(line));
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    rentals.sort(
        (r1, r2) -> {
          if (r1.getPriority() - r2.getPriority() == 0) {
            return r1.getRequestDate().compareTo(r2.getRequestDate());
          }

          return r1.getPriority() - r2.getPriority();
        });

    return rentals;
  }

  /**
   * Reads the users.csv file and returns a list containing all stored users.
   *
   * @return Map<String, String>
   */
  public List<User> getAllUsers() {
    String filename = getUsersCsvFilename();

    ArrayList<User> users = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.startsWith("name,")) continue;
        users.add(userFromCsvLine(line));
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return users;
  }

  /**
   * Reads the users.csv file and returns a hashmap containing the data of all users.
   *
   * @return Map<String, String>
   */
  public Map<String, String> getAllUsersMap() {
    String filename = getUsersCsvFilename();

    Map<String, String> userMap = new HashMap<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length >= 5) { // Ensure at least four columns exist
          String email = parts[2].trim(); // Email is in the third column
          String password = parts[3].trim(); // Password is in the fourth column
          userMap.put(email, password);
        }
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return userMap;
  }

  /**
   * Reads the users.csv file and returns a User with the given ID.
   *
   * @param id The user's ID
   * @return The user (if found), or <code>null</code>
   */
  public static User getUser(String id) {
    String filename = getUsersCsvFilename();

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.startsWith("name,")) continue;

        User user = userFromCsvLine(line);
        if (Objects.equals(user.id, id)) {
          return user;
        }
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return null;
  }

  /**
   * Reads the users.csv file and returns a User with the given email address.
   *
   * @param email The user's email
   * @return The user (if found), or <code>null</code>
   */
  public static User getUserByEmail(String email) {
    String filename = getUsersCsvFilename();

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.startsWith("name,") || line.isEmpty()) continue;

        User user = userFromCsvLine(line);
        if (Objects.equals(user.email, email)) {
          return user;
        }
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return null;
  }

  public static String fetchNewsletterContent(String urlString) throws IOException {
    URL url = new URL(urlString);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    StringBuilder content = new StringBuilder();
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line);
      }
    } finally {
      connection.disconnect();
    }

    return content.toString();
  }

  public static List<Newsletter> getNewsletters() {
    String filename = getNewslettersCsvFilename();

    ArrayList<Newsletter> items = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // ignore first line
        if (line.startsWith("id,") || line.isEmpty()) {
          continue;
        }

        items.add(newsletterFromCsvLine(line));
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return items;
  }

  public static List<Newsletter> getUserSubscription(String id) {
    String filename = getSubscribersCsvFilename();

    ArrayList<Newsletter> subscriptions = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // ignore first line
        if (line.startsWith("newsletter_id,") || line.isEmpty()) {
          continue;
        }

        String[] parts = line.split(",");
        if (!Objects.equals(parts[1], id)) continue;

        subscriptions.add(Database.getNews());
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return subscriptions;
  }

  public static Newsletter getNews() {
    String filename = getNewslettersCsvFilename();

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.startsWith("id,")) continue;

        Newsletter news = newsletterFromCsvLine(line);
        return news;
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return null;
  }

  public Textbook getTextbook(String id) {
    String filename = getTextbookCsvFilename();

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.startsWith("group_id,") || line.isEmpty()) continue;

        String[] parts = line.split(",");
        if (parts[1].equalsIgnoreCase(id)) {
          return new Textbook(getItem(id), parts[0], Integer.parseInt(parts[2]));
        }
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    return null;
  }

  public List<Textbook> getTextbooksByGroup(String groupID) {
    String filename = getTextbookCsvFilename();

    ArrayList<Textbook> textbooks = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.startsWith("group_id,") || line.isEmpty()) continue;

        String[] parts = line.split(",");
        if (!parts[0].equalsIgnoreCase(groupID)) continue;

        Item item = getItem(parts[1]);
        textbooks.add(
            item == null
                ? new Textbook(parts[0], Integer.parseInt(parts[2]))
                : new Textbook(item, parts[0], Integer.parseInt(parts[2])));
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

    textbooks.sort((t1, t2) -> t2.edition - t1.edition);
    return textbooks;
  }

  // update methods

  public static void updateUserVerification(String id, boolean verify) {
    String filename = getUsersCsvFilename();
    File tempFile = new File(filename + System.currentTimeMillis());
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");

        // update permissions
        if (Objects.equals(parts[1], id)) {
          parts[5] = String.valueOf(verify);
          line = String.join(",", parts);
        }

        writer.write(line);
        writer.newLine();
      }

      writer.close();
      reader.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    boolean renamed = tempFile.renameTo(new File(filename));
    System.out.println("UPDATE_USER_VERIFICATION: Rename success? " + renamed);
  }

  public static void updateItemCopies(String itemID, int adjustment) {
    String filename = getItemsCsvFilename();
    File tempFile = new File(getItemsCsvFilename() + System.currentTimeMillis());

    // read from original file, write to temp
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");

        // update permissions
        if (Objects.equals(parts[0], itemID)) {
          parts[8] = String.valueOf(Integer.parseInt(parts[8]) + adjustment);
          line = String.join(",", parts);
        }

        writer.write(line);
        writer.newLine();
      }

      writer.close();
      reader.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    // overwrite original file
    boolean renamed = tempFile.renameTo(new File(filename));
    System.out.println("UPDATE_ITEM_PERMISSION: Rename success? " + renamed);
  }

  /**
   * Updates a given item's permissions.
   *
   * @param itemID The item's ID.
   * @param permission The item's new permission
   */
  public static void updateItemPermission(String itemID, ItemPermission permission) {
    String filename = getItemsCsvFilename();
    File tempFile = new File(getItemsCsvFilename() + System.currentTimeMillis());

    // read from original file, write to temp
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");

        // update permissions
        if (Objects.equals(parts[0], itemID)) {
          parts[6] = String.valueOf(permission.getValue());
          line = String.join(",", parts);
        }

        writer.write(line);
        writer.newLine();
      }

      writer.close();
      reader.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    // overwrite original file
    boolean renamed = tempFile.renameTo(new File(filename));
    System.out.println("UPDATE_ITEM_PERMISSION: Rename success? " + renamed);
  }

  // delete methods

  /**
   * Removes a given item from the items.csv file.
   *
   * @param itemID The ID of the item to delete.
   */
  public static void deleteItem(String itemID) {
    String filename = getItemsCsvFilename();
    File tempFile = new File(filename + "." + System.currentTimeMillis());

    // read from original file, write to temp
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");

        // skip given item
        if (Objects.equals(parts[0], itemID)) continue;

        writer.write(line);
        writer.newLine();
      }

      writer.close();
      reader.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    // overwrite original file
    boolean renamed = tempFile.renameTo(new File(filename));
    System.out.println("DELETE_ITEM: Rename success? " + renamed);
  }

  /**
   * Removes a given item from the rentals.csv file.
   *
   * @param itemID The ID of the item.
   * @param userID The ID of the renter.
   */
  public static void deleteRental(String itemID, String userID) {
    String filename = getRentalsCsvFilename();
    File tempFile = new File(filename + "." + System.currentTimeMillis());

    // read from original file, write to temp
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");

        // skip given item
        if (Objects.equals(parts[0], itemID) && Objects.equals(parts[1], userID)) {
          continue;
        }

        writer.write(line);
        writer.newLine();
      }

      writer.close();
      reader.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    // overwrite original file
    boolean renamed = tempFile.renameTo(new File(filename));
    System.out.println("DELETE_ITEM: Rename success? " + renamed);
  }

  // helper methods

  private String getCoursesCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/courses.csv";
  }

  /**
   * Gets the absolute path of the items.csv file
   *
   * @return filename
   */
  private static String getItemsCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/items.csv";
  }

  private static String getDiscountsCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/discounts.csv";
  }

  /**
   * Gets the absolute path of the rentals.csv file
   *
   * @return filename
   */
  private static String getRentalsCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/rentals.csv";
  }

  /**
   * Gets the absolute path of the requests.csv file
   *
   * @return filename
   */
  private static String getRequestsCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/requests.csv";
  }

  private String getStudentsCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/students.csv";
  }

  private String getTextbookCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/textbooks.csv";
  }

  private static String getNewslettersCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/newsletters.csv";
  }

  private static String getSubscribersCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/subscribers.csv";
  }

  /**
   * Gets the absolute path of the users.csv file
   *
   * @return filename
   */
  private static String getUsersCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/users.csv";
  }

  /**
   * Parses a given line and returns a course
   *
   * @param line A line from courses.csv
   * @return Course
   */
  private Course courseFromCsvLine(String line) {
    String[] parts = line.split(",");

    Faculty faculty = (Faculty) getUser(parts[4]);
    Textbook textbook = getTextbook(parts[5]);
    LocalDate startDate = LocalDate.parse(parts[6]);
    LocalDate endDate = LocalDate.parse(parts[7]);

    return new Course(
        parts[0], parts[1], parts[2], parts[3], faculty, textbook, startDate, endDate);
  }

  private static Discount discountFromCsvLine(String line) {
    String[] parts = line.split(",");
    Discount discount = new Discount();
    discount.item_id = parts[0];
    discount.code = parts[1];
    discount.discount = Integer.parseInt(parts[2]);

    return discount;
  }

  /**
   * Parses a given line and returns an item
   *
   * @param line A line from items.csv
   * @return Item
   */
  private static Item itemFromCsvLine(String line) {
    String[] parts = line.split(",");
    ItemType type = ItemType.Unknown;
    for (ItemType i : ItemType.values()) {
      if (i.getValue() == Integer.parseInt(parts[3])) {
        type = i;
        break;
      }
    }

    ItemStatus status = ItemStatus.Unknown;
    for (ItemStatus i : ItemStatus.values()) {
      if (i.getValue() == Integer.parseInt(parts[5])) {
        status = i;
        break;
      }
    }

    ItemPermission permission = ItemPermission.Disabled;
    for (ItemPermission i : ItemPermission.values()) {
      if (i.getValue() == Integer.parseInt(parts[6])) {
        permission = i;
        break;
      }
    }

    Item item =
        new Item(
            parts[0],
            parts[1],
            parts[2],
            type,
            Double.parseDouble(parts[4]),
            status,
            permission,
            parts[7],
            Integer.parseInt(parts[8]));

    return item;
  }

  private static Newsletter newsletterFromCsvLine(String line) {
    String[] parts = line.split(",");
    Newsletter news = new NewsletterProxy();
    news.id = parts[0];
    news.name = parts[1];
    news.url = parts[2];
    news.fee = Double.parseDouble(parts[3]);

    return news;
  }

  /**
   * Parses a given line and returns a user
   *
   * @param line A line from users.csv
   * @return User
   */
  private static User userFromCsvLine(String line) {
    String[] parts = line.split(",");
    return UserFactory.createUser(
        parts[0], parts[2], parts[3], parts[4], parts[1], Boolean.parseBoolean(parts[5]));
  }

  /**
   * Parses a given line and returns an ItemRequest
   *
   * @param line A line from requests.csv
   * @return ItemRequest
   */
  private static ItemRequest requestFromCsvLine(String line) {
    String[] parts = line.split(",");

    ItemType itemType = ItemType.Unknown;
    for (ItemType i : ItemType.values()) {
      if (parts[1].equalsIgnoreCase(i.toString())) {
        itemType = i;
        break;
      }
    }

    return new ItemRequest(
        parts[0],
        itemType,
        parts[2],
        parts[3],
        parts[4],
        Integer.parseInt(parts[5]),
        LocalDate.parse(parts[6]));
  }
}
