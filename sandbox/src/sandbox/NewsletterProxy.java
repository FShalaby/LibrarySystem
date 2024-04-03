package sandbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsletterProxy extends Newsletter{
	public Newsletter newsletter;
	List<Newsletter> subscriptions = new ArrayList<Newsletter>();
	public NewsletterProxy()
	{
		super();
		new NewsletterProxy(this);
	}
	public NewsletterProxy(Newsletter newsletter) 
	{
        this.newsletter = newsletter;
    }
	
	@Override
	public Boolean subscribe(User user, Newsletter newsletter, Payment payment) {
		// TODO Auto-generated method stub
		subscriptions = Database.getUserSubscription(user.id);
		boolean check = false;
		for( Newsletter i : subscriptions)
		{
			if (subscriptions.contains(i))
			{
				check = true;
			}
		}
		if(user.subscriptions.isEmpty() && check == false)
		{
			user.subscriptions.put(newsletter, true);
			System.out.println(("Process "+payment+" $"+newsletter.fee));
			return true;
		}
		else {
			for (Newsletter i : user.subscriptions.keySet()) {
				if (user.subscriptions.get(i)) {
					System.out.print("Already Subscribed to " + newsletter);
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public Boolean cancelSubscription(User user, Newsletter newsletter) {
		// TODO Auto-generated method stub
		if (user.subscriptions.containsKey(newsletter) && user.subscriptions.get(newsletter)) {
            // Update the subscription status to false
            user.subscriptions.put(newsletter, false);
            System.out.println("Subscription to " + newsletter + " canceled successfully.");
			return true;
        } else {
            System.out.println("Subscription to " + newsletter+ " not found or already canceled.");
			return false;
        }
    }
	}

