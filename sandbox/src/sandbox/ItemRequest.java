package sandbox;

import java.time.LocalDate;

public class ItemRequest {
  // constants
  private static final int HIGH_PRIORITY = 0;
  private static final int LOW_PRIORITY = 1;

  // attributes
  private final String itemName;
  private final ItemType itemType;
  private final String itemID;
  private final String reason;
  private final String additionalInfo;
  private final int priority;
  private final LocalDate requestDate;

  public ItemRequest(
      String itemName, ItemType itemType, String itemID, String reason, String additionalInfo) {
    this.itemName = itemName;
    this.itemType = itemType;
    this.itemID = itemID;
    this.reason = reason;
    this.additionalInfo = additionalInfo;
    this.priority = reason.contains("teaching") ? HIGH_PRIORITY : LOW_PRIORITY;
    this.requestDate = LocalDate.now();
  }

  public ItemRequest(
      String itemName,
      ItemType itemType,
      String itemID,
      String reason,
      String additionalInfo,
      int priority,
      LocalDate requestDate) {
    this.itemName = itemName;
    this.itemType = itemType;
    this.itemID = itemID;
    this.reason = reason;
    this.additionalInfo = additionalInfo;
    this.priority = priority;
    this.requestDate = requestDate;
  }

  public String getItemName() {
    return itemName;
  }

  public ItemType getItemType() {
    return itemType;
  }

  public String getItemID() {
    return itemID;
  }

  public String getReason() {
    return reason;
  }

  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public int getPriority() {
    return priority;
  }

  public LocalDate getRequestDate() {
    return requestDate;
  }
}
