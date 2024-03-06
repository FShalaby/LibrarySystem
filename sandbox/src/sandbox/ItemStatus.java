package sandbox;

public enum ItemStatus {
  Unknown(-1),
  Available(0),
  Rented(1),
  Purchased(2);

  private final int value;

  private ItemStatus(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
