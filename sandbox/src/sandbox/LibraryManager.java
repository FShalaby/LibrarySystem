package sandbox;

public class LibraryManager {
	 private Command addItemCommand;
	 private Command enableItemCommand;
	 private Command disableItemCommand;
	 private Command deleteItemCommand;
	 private Command verifyUserCommand;

	 public LibraryManager(Command addItemCommand, Command enableItemCommand, Command disableItemCommand, Command deleteItemCommand, Command verifyUserCommand) {
	        this.addItemCommand = addItemCommand;
	        this.enableItemCommand = enableItemCommand;
	        this.disableItemCommand = disableItemCommand;
	        this.deleteItemCommand = deleteItemCommand;
	        this.verifyUserCommand = verifyUserCommand;
	    }

	 public void addItemToLibrary() {
	        addItemCommand.execute(); // Executes the addItemCommand
	    }

	    public void enableItemForRenting() {
	        enableItemCommand.execute(); // Executes the enableItemCommand
	    }

	    public void disableItemForRenting() {
	        disableItemCommand.execute(); // Executes the disableItemCommand
	    }
	    public void deleteItem()
	    {
	    	deleteItemCommand.execute();
	    }
	    public void verifyUser()
	    {
	    	verifyUserCommand.execute();
	    }
//	public static boolean verify(User user)
//	{
//		user.isVerified =true;
//		return user.isVerified;
//		
//	}
}
