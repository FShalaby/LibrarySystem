package sandbox;

public class UserFactory {
	 public static User createUser(String name, String email, String password, String userType) {
	        switch (userType.toLowerCase()) {
	            case "student":
	                return new Student(name, email, password,userType);
	            case "faculty":
	                return new Faculty(name, email, password, userType);
	            case "non-faculty":
	                return new NonFaculty(name, email, password, userType);
	            case "visitor":
	                return new Visitor(name, email, password, userType);
	            default:
	                throw new IllegalArgumentException("Invalid user type");
	        }
	    }
}
