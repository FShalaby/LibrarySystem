package sandbox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryStrategy extends Item implements BookStrategy
{
	List<Item> recommendations = new ArrayList<>();
	
	@Override
	public  List<Item> search(String query) 
	{		
	    for (String itemName : LibrarySystem.genre.keySet()) 
	    {
	        String category = LibrarySystem.genre.get(itemName);
	        if (category.equalsIgnoreCase(query)) {
	            // Retrieve the item from the item map using the item name
	            Item item = LibrarySystem.getItemMap().get(itemName);
	            if (item != null) {
	                recommendations.add(item);
	            }
	        }
	    }
	    return recommendations;
    }
}
