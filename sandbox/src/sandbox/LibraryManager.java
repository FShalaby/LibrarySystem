package sandbox;

public class LibraryManager {
	
	public static boolean verify(User user)
	{
		user.isVerified =true;
		return user.isVerified;
		
	}
}
