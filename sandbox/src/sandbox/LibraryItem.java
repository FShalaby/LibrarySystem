package sandbox;
import java.util.HashMap;

public abstract class LibraryItem 
{
	public String name;
	public String type;
	public double price;
	public boolean rentStatus;
	public int copies;
	public abstract int getCopies();
	public abstract int setCopies(int copies);

}
