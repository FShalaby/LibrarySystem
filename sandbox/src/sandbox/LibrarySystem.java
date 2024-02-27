package sandbox;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class LibrarySystem 
{
	public Item item;
	public User user;
	HashMap<String,Integer> inventory = new HashMap<String,Integer>();
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
			
		
		
	
	
	public String BuyItem(Item item, Payment payment, User user)
	{
		if(item.permission.equals(ItemPermission.Purchasable) && item.copies>0)
		{
			// Process the payment
	        boolean paymentProcessed = payment.processPayment(item.price);
			
	        if(paymentProcessed)
	        {
		            user.rented.add(item);
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
}

