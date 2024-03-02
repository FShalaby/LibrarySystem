package sandbox;

import java.util.HashMap;
import java.util.Map;

public class NewsletterProxy implements Newsletter{
	public Newsletter newsletter;
	
	
	public NewsletterProxy(Newsletter newsletter) 
	{
        this.newsletter = newsletter;
    }
	
	@Override
	public void subscribe(User user, Newsletter newsletter) {
		// TODO Auto-generated method stub
		for(Newsletter i: user.subscriptions.keySet())
		{
			if(user.subscriptions.get(i))
			{
				System.out.print("Already Subscribed to "+ newsletter);
				return;
			}
		}
		user.subscriptions.put(newsletter, true);
		
	}

	@Override
	public void cancelSubscription(User user, Newsletter Newsletter) {
		// TODO Auto-generated method stub
		if (user.subscriptions.containsKey(newsletter) && user.subscriptions.get(newsletter)) {
            // Update the subscription status to false
            user.subscriptions.put(newsletter, false);
            System.out.println("Subscription to " + newsletter + " canceled successfully.");
        } else {
            System.out.println("Subscription to " + newsletter+ " not found or already canceled.");
        }
    }
	}

