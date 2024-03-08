package sandbox;

public interface Newsletter 
{
	public void subscribe(User user, Newsletter newsletter);
	public void cancelSubscription(User user, Newsletter Newsletter);
}
