package sandbox;

public class CurrentUser {
    private static User userInstance;
    private CurrentUser() {}

    public static User getUserInstance() {
        return userInstance;
    }

    public static void setUserInstance(User userInstance) {
        CurrentUser.userInstance = userInstance;
    }
}
