package sandbox;

//ABSTRACT FACTORY METHOD

public class MobileWalletPayment implements Payment
{

	@Override
	public boolean processPayment(double amount) 
	{
		// Implement mobile wallet payment processing logic here
		
        System.out.println("Processing mobile wallet payment of $" + amount);
        
        // Return true if payment is successful, false otherwise
        return true;
	}

}
