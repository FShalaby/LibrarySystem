package sandbox;

public class Textbook extends Item {
  public String groupID;
  public int edition;

  public Textbook(Item item, String groupID, int edition) {
    super(
        item.id,
        item.name,
        item.location,
        item.type,
        item.price,
        item.status,
        item.permission,
        item.category,
        item.copies);

    this.groupID = groupID;
    this.edition = edition;
  }

  public Textbook(String groupID, int edition) {
    this.groupID = groupID;
    this.edition = edition;
  }
}
