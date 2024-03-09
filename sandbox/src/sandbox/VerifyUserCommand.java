package sandbox;

public class VerifyUserCommand implements Command
{
	private User user;
	
	public VerifyUserCommand(User user)
	{
		this.user=user;
	}
	
	public void execute() 
	{
		this.user.isVerified=true; //temporary until we figure a way to better verify
				
	}

}
