package sandbox;

public class AddItemCommand implements Command
{
	private Item item;
    
    public AddItemCommand(Item item) {
        this.item = item;
    }
	
	public void execute() 
	{
		LibrarySystem.inventory.put(item.name, item.copies);
		Database.insertItem(this.item);
	}

}
