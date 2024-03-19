package sandbox;

import java.io.*;
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
              "%s,%s,%s,%d,%.2f,%d,%d,%s,%d,%s,%b",
              item.id,
              item.name,
              item.location,
              item.type.getValue(),
              item.price,
              item.status.getValue(),
              item.permission.getValue(),
              item.category,
              item.copies,
              item.dueDate,
              item.isLost));
      writer.close();

      System.out.println("Item data has been written to the CSV file.");
    } catch (IOException ex) {
      System.err.println(ex.getMessage());
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

  /** Inserts a new row into the users.csv table */
  public void insertUser(String name, String id, String email, String pass, String type, boolean verified) {
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
              "%s,%s,%s,%s,%s,%s", name, id, email, pass, type, verified)); // Assuming ID is the second column
      writer.newLine();
      System.out.println("User data has been written to the CSV file.");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  // read methods

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
      e.printStackTrace();
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

  /**
   * Reads the rentals.csv file and returns a list containing all rentals.
   *
   * @return A list of maps containing the user's id as the key, and the rented item (<code>Item
   *     </code>) as the value.
   */
  public static List<Map<String, Item>> getAllRentals() {
    String filename = getRentalsCsvFilename();

    ArrayList<Map<String, Item>> rentals = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // ignore first line
        if (line.startsWith("item_id,")) {
          continue;
        }

        String[] parts = line.split(",");
        Item rented = getItem(parts[0]);
        rented.dueDate = LocalDate.parse(parts[2]);

        Map<String, Item> rental = new HashMap<>();
        rental.put(parts[1], rented);
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
  public List<Item> getUserRentals(String id) {
    String filename = getRentalsCsvFilename();

    ArrayList<Item> rentals = new ArrayList<>();
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
        rented.dueDate = LocalDate.parse(parts[2]);
        rentals.add(rented);
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }

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
      e.printStackTrace();
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

  public ArrayList<String[]> getValidated() {
    String filename = getValidatedCsvFilename();


    ArrayList<String[]> validList = new ArrayList<String[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        String userData[] = new String[2];


        if (parts.length >= 2) { // Ensure at least Two columns exist (last name, first name, type)
          String name = parts[0].trim(); // Name is the first column
          String type = parts[1].trim(); // Type name is the second column
          userData[0] = name;
          userData[1] = type;
        }
        validList.add(userData);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return validList;
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
        if (line.startsWith("name,")) continue;

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
  
  

  // update methods
  
  public static void updateUserVerification(String id, boolean verify)
  {
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
	    System.out.println("UPDATE_User_Verfication: Rename success? " + renamed);
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
  public void deleteRental(String itemID, String userID) {
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

  /**
   * Gets the absolute path of the items.csv file
   *
   * @return filename
   */
  private static String getItemsCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/items.csv";
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
   * Gets the absolute path of the users.csv file
   *
   * @return filename
   */
  private static String getUsersCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/users.csv";
  }

  /**
   * Gets the absolute path of the verified.csv file
   * This contains accepted names in the system for validation. i.e names connected to our imaginary school
   *
   * @return filename
   */
  private static String getValidatedCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/verified.csv";
  }


  private static Item itemFromCsvLine(String line) {
	    String[] parts = line.split(",");
	    Item item = new Item();
	    item.id = parts[0];
	    item.name = parts[1];
	    item.location = parts[2];
	    item.type = ItemType.Unknown;
	    for (ItemType i : ItemType.values()) {
	      if (i.getValue() == Integer.parseInt(parts[3])) {
	        item.type = i;
	        break;
	      }
	    }

	    item.price = Double.parseDouble(parts[4]);
	    item.status = ItemStatus.Unknown;
	    for (ItemStatus i : ItemStatus.values()) {
	      if (i.getValue() == Integer.parseInt(parts[5])) {
	        item.status = i;
	        break;
	      }
	    }

	    item.permission = ItemPermission.Disabled;
	    for (ItemPermission i : ItemPermission.values()) {
	      if (i.getValue() == Integer.parseInt(parts[6])) {
	        item.permission = i;
	        break;
	      }
	    }

	    item.category = parts[7];
	    item.copies = Integer.parseInt(parts[8]);
	    item.isLost = Boolean.parseBoolean(parts[9]);

	    return item;
	  }

  private static User userFromCsvLine(String line) {
    String[] parts = line.split(",");
    return UserFactory.createUser(parts[0], parts[2], parts[3], parts[4], parts[1], Boolean.parseBoolean(parts[5]));
  }
}
