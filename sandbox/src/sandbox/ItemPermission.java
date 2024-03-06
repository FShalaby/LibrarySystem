package sandbox;

public enum ItemPermission {
	Disabled(0),
	Rentable(1),
	Purchasable(2),
	RentableAndPurchasable(3);

  private final int value;

  private ItemPermission(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
