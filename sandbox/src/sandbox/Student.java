package sandbox;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
  private List<Course> courses = new ArrayList<>();

  public Student(String name, String email, String password, String type, boolean verify) {
    this.name = name;
    this.email = email;
    this.pw = password;
    this.type = type;
    this.id = generateRandomID();
    this.isVerified = verify;
  }

  public Student(
      String name, String email, String password, String type, String id, boolean verify) {
    this.name = name;
    this.email = email;
    this.pw = password;
    this.type = type;
    this.id = id;
    this.isVerified = verify;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }
}
