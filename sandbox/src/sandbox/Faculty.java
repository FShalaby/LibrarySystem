package sandbox;

import java.util.ArrayList;

public class Faculty extends User {
  ArrayList courses = new ArrayList<Course>();

  public Faculty(String name, String email, String password, String type, boolean verify) {
    this.name = name;
    this.email = email;
    this.pw = password;
    this.type = type;
    this.id = generateRandomID();
    this.isVerified = verify;
  }

  public Faculty(String name, String email, String password, String type, String id, boolean verify) {
    this.name = name;
    this.email = email;
    this.pw = password;
    this.type = type;
    this.id = id;
    this.isVerified = verify;
  }
}
