package sandbox;

import java.util.ArrayList;

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

	 public static boolean verify(User user)
	 {
	 	 //Actual verification against list in verified.csv
		 Database databaseRef = Database.getInstance();
		 ArrayList<String[]> toCheck = databaseRef.getValidated();

		 for(String[] userData : toCheck)
		 {
			 System.out.println(userData[0] + " " + userData[1]);
			 //Checking name match
			 if((user.name).equalsIgnoreCase(userData[0]))
			 {
				 //Checking type match
				 if((user.type).equalsIgnoreCase(userData[1]))
				 {
					 //"Wraps" user in validated decorator
					 ValidatedUser validated = new ValidatedUser(user);
					 user.isVerified =true;

					 //Creation was verified
					 return validated.getIsVerified();
				 }
			 }
		 }
		 //Creation was not verified
		 return false;  
	}
}
