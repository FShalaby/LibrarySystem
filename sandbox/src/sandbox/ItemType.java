package sandbox;

public enum ItemType {
  Unknown(-1),
  Book(0),
  Magazine(1),
  CD(2),
  Textbook(3);

  private int value;

  private ItemType(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
