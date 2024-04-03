package sandbox;

public class DeleteItemCommand implements Command
{
	private Item item;
	
	public DeleteItemCommand(Item item)
	{
		this.item=item;
	}
	public void execute() 
	{
		LibrarySystem.inventory.remove(this.item.name);
		Database.deleteItem(this.item.id);
	}
	

}
