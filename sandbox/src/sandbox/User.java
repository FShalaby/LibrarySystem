package sandbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public abstract class User {
  public String name;
  public String email;
  public String id;
  public String type;
  protected String pw;
  public boolean isVerified;
  protected int limit = 0;
  protected int overdue = 0;
  public List<Item> rentedItems = new ArrayList<>();
  public HashMap<Newsletter, Boolean> subscriptions;

  // Generate random ID()
  protected static String generateRandomID() {
    // Generate a random UUID
    UUID uuid = UUID.randomUUID();
    // Convert UUID to string, remove hyphens, and get the first 6 characters
    return uuid.toString().replaceAll("-", "").substring(0, 6);
  }

  // write on the CSV
  // ===============================

  public synchronized void writeUserCsv() {
    Database.getInstance().insertUser(this.name, this.id, this.email, this.pw, this.type);
  }
}
