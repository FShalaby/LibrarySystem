package sandbox;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public abstract class Item 
{
	public String id;
	public String name;
	public String location;
	public ItemType type;
	public double price;
	public ItemStatus status;
	public ItemPermission permission;
	public String category;
	public int copies;
	public LocalDate dueDate;
	public boolean isLost = false;

}
