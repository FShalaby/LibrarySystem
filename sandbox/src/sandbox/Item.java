package sandbox;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Item {
  public String id;
  public String name;
  public String location;
  public ItemType type;
  public Double price;
  public ItemStatus status;
  public ItemPermission permission;
  public String category;
  public int copies;
  public LocalDate dueDate;

  public Item() {}

  public Item(
      String id,
      String name,
      String location,
      ItemType type,
      Double price,
      ItemStatus status,
      ItemPermission permission,
      String category,
      int copies) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.type = type;
    this.price = price;
    this.status = status;
    this.permission = permission;
    this.category = category;
    this.copies = copies;
  }

  public String generateUniqueID() {
    String uuid = UUID.randomUUID().toString();
    // Extract the first 18 characters
    return uuid.substring(0, 18);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Item) {
      return Objects.equals(this.id, ((Item) o).id);
    }

    return Objects.equals(this, o);
  }
}
