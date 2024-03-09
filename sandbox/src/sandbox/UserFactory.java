package sandbox;

public class UserFactory {
  public static User createUser(String name, String email, String password, String userType) {
    return switch (userType.toLowerCase().trim()) {
      case "student" -> new Student(name, email, password, userType);
      case "faculty" -> new Faculty(name, email, password, userType);
      case "non-faculty" -> new NonFaculty(name, email, password, userType);
      case "visitor" -> new Visitor(name, email, password, userType);
      default -> throw new IllegalArgumentException("Invalid user type");
    };
  }

  public static User createUser(String name, String email, String password, String userType, String id) {
    return switch (userType.toLowerCase().trim()) {
      case "student" -> new Student(name, email, password, userType, id);
      case "faculty" -> new Faculty(name, email, password, userType, id);
      case "non-faculty" -> new NonFaculty(name, email, password, userType, id);
      case "visitor" -> new Visitor(name, email, password, userType, id);
      default -> throw new IllegalArgumentException("Invalid user type");
    };
  }
}
