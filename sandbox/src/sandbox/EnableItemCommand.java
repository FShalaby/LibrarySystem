package sandbox;

public class EnableItemCommand implements Command
{
	private Item item;

    public EnableItemCommand(Item item) {
        this.item = item;
    }
	
	public void execute() {
		this.item.permission= ItemPermission.Rentable;
		Database.updateItemPermission(this.item.id, this.item.permission);
	}
	
}
