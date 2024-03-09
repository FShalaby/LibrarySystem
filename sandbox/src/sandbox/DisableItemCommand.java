package sandbox;

public class DisableItemCommand implements Command
{
	private Item item;

    public DisableItemCommand(Item item) {
        this.item = item;
    }
	
	public void execute() {
		this.item.permission = ItemPermission.Disabled;
		Database.updateItemPermission(this.item.id, this.item.permission);
		
	}

}
