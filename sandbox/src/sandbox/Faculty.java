package sandbox;

public class Faculty extends User {

	public Faculty(String name, String email, String password, String type) {
		// TODO Auto-generated constructor stub
		 this.name = name;
	        this.email = email;
	        this.pw = password;
	        this.type = type;
	        this.id = this.generateRandomID();
	        writeUserCsv(this.name, this.email, this.pw, this.id);
	    }
	}


