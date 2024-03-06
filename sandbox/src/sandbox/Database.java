package sandbox;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  /** Inserts a new row into the users.csv table */
  public void insertUser(String name, String id, String email, String pass) {
    String filename = getUsersCsvFilename();

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
      // Append user data to the CSV file
      writer.newLine();
      writer.write(
          String.format("%s,%s,%s,%s", name, id, email, pass)); // Assuming ID is the second column
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
        if (line.startsWith("id,")) {
          continue;
        }

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
        item.dueDate = LocalDate.parse(parts[9]);
        item.isLost = Boolean.parseBoolean(parts[10]);

        items.add(item);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return items;
  }

  /**
   * Reads the users.csv file and returns a hashmap containing the data of all users.
   *
   * @return Map<String, String>
   */
  public Map<String, String> getAllUsers() {
    String filename = getUsersCsvFilename();

    Map<String, String> userMap = new HashMap<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length >= 4) { // Ensure at least four columns exist
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

  // update methods

  // delete methods

  // helper methods

  /**
   * Gets the absolute path of the items.csv file
   *
   * @return filename
   */
  private String getItemsCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/items.csv";
  }

  /**
   * Gets the absolute path of the users.csv file
   *
   * @return filename
   */
  private String getUsersCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/db/users.csv";
  }
}
