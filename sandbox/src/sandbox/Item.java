package sandbox;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

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
	
	public String generateUniqueID() {
	    String uuid = UUID.randomUUID().toString();
	    // Extract the first 18 characters
	    return uuid.substring(0, 18);
	}

}
