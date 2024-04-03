package sandbox;

public abstract class Newsletter
{
	public String id = null;
	public String name = null;
	public String url = null;
	public double fee = 0.0;
	public Newsletter()
	{

	}

	public abstract Boolean subscribe(User user, Newsletter newsletter, Payment payment);
	public abstract Boolean cancelSubscription(User user, Newsletter Newsletter);

}
