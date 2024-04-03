package sandbox;

public enum ItemPermission {
  Disabled(0),
  Rentable(1),
  Purchasable(2),
  RentableAndPurchasable(3);

  private final int value;

  ItemPermission(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public static ItemPermission from(int num) {
    switch (num) {
      case 1:
        return ItemPermission.Rentable;
      case 2:
        return ItemPermission.Purchasable;
      case 3:
        return ItemPermission.RentableAndPurchasable;
      default:
        return ItemPermission.Disabled;
    }
  }
}
