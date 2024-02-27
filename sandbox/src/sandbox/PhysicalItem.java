package sandbox;
import java.util.HashMap;
import java.util.ArrayList;
public class PhysicalItem extends Item
{
	ArrayList<String>inv = new ArrayList<String>();
	
	  public PhysicalItem(String id, String name, String location, ItemType type, double price, ItemStatus status, ItemPermission permission) {
	        this.id = id;
	        this.name = name;
	        this.location = location;
	        this.type = type;
	        this.price = price;
	        this.status = status;
	        this.permission = permission;
	        this.copies = 20;
	        
	        boolean found = false;
	        for (String itemName : inv) {
	            if (name.equals(itemName)) 
	            {
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            inv.add(name);
	        }
	    }
}
