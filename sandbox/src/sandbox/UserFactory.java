package sandbox;

public class UserFactory {
  public static User createUser(String name, String email, String password, String userType, boolean verify) {
    return switch (userType.toLowerCase().trim()) {
      case "student" -> new Student(name, email, password, userType, verify);
      case "faculty" -> new Faculty(name, email, password, userType, verify);
      case "non-faculty" -> new NonFaculty(name, email, password, userType, verify);
      case "visitor" -> new Visitor(name, email, password, userType);
      case "manager" -> new LibraryManager(name, email, password, userType);
      default -> throw new IllegalArgumentException("Invalid user type");
    };
  }

  public static User createUser(String name, String email, String password, String userType, String id,  boolean verify) {
    return switch (userType.toLowerCase().trim()) {
      case "student" -> new Student(name, email, password, userType, id, verify);
      case "faculty" -> new Faculty(name, email, password, userType, id, verify);
      case "non-faculty" -> new NonFaculty(name, email, password, userType, id, verify);
      case "visitor" -> new Visitor(name, email, password, userType, id);
      case "manager" -> new LibraryManager(name, email, password, userType, id);
      default -> throw new IllegalArgumentException("Invalid user type");
    };
  }
}
