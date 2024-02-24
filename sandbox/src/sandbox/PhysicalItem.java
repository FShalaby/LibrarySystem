package sandbox;
import java.util.HashMap;
import java.util.ArrayList;
public class PhysicalItem extends LibraryItem
{
	ArrayList<String>added = new ArrayList<String>();
	public PhysicalItem(String name, String type, Double price, Boolean rentStatus)
	{
		this.name=name;
		this.type=type;
		this.price=price;
		this.rentStatus=rentStatus;
		 if (!added.contains(name)) {
	            this.copies = 20;
	            added.add(name);
	        }
	}
	public PhysicalItem()
	{
		
	}
	
	@Override
	public int getCopies() {
		// TODO Auto-generated method stub
		return this.copies;
	}
	@Override
	public int setCopies(int copies) {
		return this.copies=copies;
	}


}
