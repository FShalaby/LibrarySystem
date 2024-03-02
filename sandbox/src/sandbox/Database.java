package sandbox;

import java.io.*;
import java.util.HashMap;
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

  /** */
  public void insertUser(String name, String id, String email, String pass) {
    String filename = getUserCsvFilename();

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
   * Reads the user.csv file and returns a hashmap containing the data of all users.
   *
   * @return Map<String, String>
   */
  public Map<String, String> getAllUsers() {
    String filename = getUserCsvFilename();

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
   * Gets the absolute path of the user.csv file
   *
   * @return filename
   */
  private String getUserCsvFilename() {
    String path = new File("").getAbsolutePath();
    return path + "/user.csv";
  }
}
