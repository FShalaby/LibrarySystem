package sandbox;

import java.util.ArrayList;

public class LibraryManager extends User{
	 private Command addItemCommand;
	 private Command enableItemCommand;
	 private Command disableItemCommand;
	 private Command deleteItemCommand;
	 private Command returnItemCommand;

	 public LibraryManager(String name, String email, String password, String userType) 
	 	{
		 	this.id = generateRandomID();
		 	this.name = name;
		 	this.pw=password;
		 	this.type=userType;
		 	this.isVerified = true;
	    }
	 public LibraryManager(String name, String email, String password, String type, String id) {
		    this.name = name;
		    this.email = email;
		    this.pw = password;
		    this.type = type;
		    this.id = id;
		    this.isVerified = true;
		  }
	 public void setAddItemCommand(Command addItemCommand) {
	        this.addItemCommand = addItemCommand;
	    }

	    public void setEnableItemCommand(Command enableItemCommand) {
	        this.enableItemCommand = enableItemCommand;
	    }

	    public void setDisableItemCommand(Command disableItemCommand) {
	        this.disableItemCommand = disableItemCommand;
	    }

	    public void setDeleteItemCommand(Command deleteItemCommand) {
	        this.deleteItemCommand = deleteItemCommand;
	    }

		public void setReturnItemCommand(Command returnItemCommand){this.returnItemCommand = returnItemCommand;}

	    
	    

	 public void addItemToLibrary(Command command) {
	        addItemCommand.execute(); // Executes the addItemCommand
	    }

	    public void enableItemForRenting(Command command) {
	        enableItemCommand.execute(); // Executes the enableItemCommand
	    }

	    public void disableItemForRenting(Command command) {
	        disableItemCommand.execute(); // Executes the disableItemCommand
	    }
	    public void deleteItem(Command command)
	    {
	    	deleteItemCommand.execute();
	    }
		public void returnItem(Command command)
		{
			returnItemCommand.execute();
		}

	 public static boolean verify(User user)
	 {
	 	 //Actual verification against list in verified.csv
		user.isVerified = true;
		return true;
		
	}
}
