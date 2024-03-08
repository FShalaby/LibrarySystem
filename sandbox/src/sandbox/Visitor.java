package sandbox;

public class Visitor extends User {

  public Visitor(String name, String email, String password, String type) {
    this.name = name;
    this.email = email;
    this.pw = password;
    this.type = type;
    this.id = generateRandomID();
    this.isVerified = true;
  }
}
