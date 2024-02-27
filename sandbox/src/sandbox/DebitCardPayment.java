package sandbox;


//ABSTRACT FACTORY METHOD

public class DebitCardPayment  implements Payment
{

	 @Override
	    public boolean processPayment(double amount) 
	 {
	        // Implement debit card payment processing logic here
	        System.out.println("Processing debit card payment of $" + amount);
	        
	        // Return true if payment is successful, false otherwise
	        return true;
	    }
	
	

}
