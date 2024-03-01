package sandbox;

public class Visitor extends User{

	
	public Visitor(String name, String email, String password, String type)
	{
		this.name=name;
		this.email=email;
		this.pw=password;
		this.type = type;
		this.id = this.generateRandomID();
		this.isVerified = true;
		 writeUserCsv(this.name, this.email, this.pw, this.id);
	}
	

}
