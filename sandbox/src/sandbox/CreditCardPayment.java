package sandbox;

//ABSTRACT FACTORY METHOD

public class CreditCardPayment implements Payment
{

	@Override
	public boolean processPayment(double amount) 
	{
		// Implement credit card payment processing logic here
		
        System.out.println("Processing credit card payment of $" + amount);
        
        // Return true if payment is successful, false otherwise
        return true;
	}

}
