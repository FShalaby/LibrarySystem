package sandbox;

public class NonFaculty extends User {

  public NonFaculty(String name, String email, String password, String type, boolean verify) {
    // TODO Auto-generated constructor stub
    this.name = name;
    this.email = email;
    this.pw = password;
    this.type = type;
    this.id = generateRandomID();
    this.isVerified = verify;
  }

  public NonFaculty(String name, String email, String password, String type, String id, boolean verify) {
    // TODO Auto-generated constructor stub
    this.name = name;
    this.email = email;
    this.pw = password;
    this.type = type;
    this.id = id;
    this.isVerified = verify;
  }
}
