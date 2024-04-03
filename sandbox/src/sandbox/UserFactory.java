package sandbox;

public class UserFactory {
  public static User createUser(
      String name, String email, String password, String userType, boolean verify) {
    switch (userType.toLowerCase().trim()) {
      case "student":
        return new Student(name, email, password, userType, verify);
      case "faculty":
        return new Faculty(name, email, password, userType, verify);
      case "non-faculty":
        return new NonFaculty(name, email, password, userType, verify);
      case "visitor":
        return new Visitor(name, email, password, userType);
      case "manager":
        return new LibraryManager(name, email, password, userType);
      default:
        throw new IllegalArgumentException("Invalid user type");
    }
  }

  public static User createUser(
      String name, String email, String password, String userType, String id, boolean verify) {
    switch (userType.toLowerCase().trim()) {
      case "student":
        return new Student(name, email, password, userType, id, verify);
      case "faculty":
        return new Faculty(name, email, password, userType, id, verify);
      case "non-faculty":
        return new NonFaculty(name, email, password, userType, id, verify);
      case "visitor":
        return new Visitor(name, email, password, userType, id);
      case "manager":
        return new LibraryManager(name, email, password, userType, id);
      default:
        throw new IllegalArgumentException("Invalid user type");
    }
  }
}
