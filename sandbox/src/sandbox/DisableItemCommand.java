package sandbox;

public class DisableItemCommand implements Command {
  private final Item item;

  public DisableItemCommand(Item item) {
    this.item = item;
  }

  public void execute() {
    this.item.permission = ItemPermission.from(this.item.permission.getValue() & 0b10);
    Database.updateItemPermission(this.item.id, this.item.permission);
  }
}
