package sandbox;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public  class LibrarySystem 
{
	public Item item;
	public User user;
	public static HashMap<String,Integer> inventory = new HashMap<String,Integer>();
	public static HashMap<String,String> genre = new HashMap<String,String>();
    public static HashMap<String, Item> itemMap = new HashMap<>();
//    public List<Item> recommendations = new ArrayList<Item>();
	public double penalty = 0.5;
	public Payment payment;
	
	
	public String RentItem(Item item, User user)
	{
		if(user.limit<10 && item.permission.equals(ItemPermission.Rentable) && item.copies>0 && user.overdue<3)
		{
				    item.status = ItemStatus.Rented;
		     	    user.rented.add(item);
		            inventory.put(item.name, item.copies - 1);
		           
		            
		            LocalDate currentDate = LocalDate.now();
		            LocalDate dueDate = currentDate.plusDays(30);
		            item.dueDate = dueDate;
		            
		         // Check for overdue
		            LocalDate today = LocalDate.now();
		            if (today.isAfter(dueDate)) {
		                long overdueDays = today.toEpochDay() - dueDate.toEpochDay();
		                
		             // Calculate overdue fee
		                double fine = overdueDays * penalty; 
		                user.overdue = user.overdue + 1;
		                return "Item " + item.name + " rented successfully. Overdue fee: $" + fine;
		            }

		            // Check if it's been more than 15 days
		            if (currentDate.isAfter(dueDate.plusDays(15))) {
		                item.isLost = true;
		            }
		            return "Item " + item.name + " rented successfully.";
		} 
			
		    return "Sorry, item " + item.name + " cannot be rented";    
	}
	
	public Item searchItem(String name)
	{
		String lowercaseName = name.toLowerCase(); // Convert search query to lowercase
	    
	    for (String itemName : inventory.keySet()) {
	        String lowercaseItemName = item.name.toLowerCase(); // Convert item name to lowercase
	        if (lowercaseItemName.equals(lowercaseName)) 
	        {
	            return item; // Return the item if found
	        }
	    }
	    
	    return null;
	}
	
	public List<Item> getRecommendations(String category)
	{
		 CategoryStrategy categoryStrategy = new CategoryStrategy();
		    return categoryStrategy.search(category);
	}
		
//	public List<Item> displayRecommendations(List<Item> recommendations)
//	{
//		if (recommendations.isEmpty()) {
//	       return null;
//	    } else {
//	 
//	       return recommendations; // return the list
//	    }
//	}	
	
	
	public String BuyItem(Item item, Payment payment, User user)
	{
		if(item.permission.equals(ItemPermission.Purchasable) && item.copies>0)
		{
			// Process the payment
	        boolean paymentProcessed = payment.processPayment(item.price);
			
	        if(paymentProcessed)
	        {
//		            user.rented.add(item);
		            item.status = ItemStatus.Purchased;
		            inventory.put(item.name, item.copies - 1);
		            return "Item " + item.name + " purchased successfully.";
	        }
		        else 
		        {
		            return "Payment processing failed for item " + item.name + ".";
		        }
		} 
			
		    return "Sorry, item " + item.name + " cannot be purchased"; 
	}
		
	public ArrayList displayRentedBooks(User user)
	{
		return user.rented;
	}
	
	public HashMap<String, Integer> getInventory() {
		// TODO Auto-generated method stub
		return inventory;
	}
	public static HashMap<String, Item> getItemMap() {

        return itemMap;
    }
	public String toString() {
	    return "Name: " + item.name + "\n"
	            + "Category: " + item.category + "\n"
	            + "Location: " + item.location + "\n"
	            + "Permission: " + item.permission + "\n"
	            + "Price: " + item.price + "\n"
	            + "Inventory: " + item.copies + "\n";
	}
}

