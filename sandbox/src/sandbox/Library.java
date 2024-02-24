package sandbox;
import java.util.HashMap;

public class Library 
{
	public LibraryItem item = new PhysicalItem();
	HashMap<String,Integer> inventory = new HashMap<String,Integer>();
	public void RentItem(LibraryItem item)
	{
		inventory.put(item.name, item.setCopies(item.getCopies()-1));
	}
	public HashMap<String, Integer> getInventory() {
		// TODO Auto-generated method stub
		return inventory;
	}
}
