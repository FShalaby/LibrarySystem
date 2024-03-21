package ui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import sandbox.User;

public class NonFacultyWindow  extends MainWindow {
	public static User user;
    public NonFacultyWindow(User user) {
        super();
        this.user=user;
        setTitle("Library System");
        // Customize the window for faculty user
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new NonFacultyWindow(user).showLoginDialog());
//    }

}
