package ui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import sandbox.User;

public class FacultyWindow extends MainWindow {
	public static User user;
    public FacultyWindow(User user) {
        super();
        this.user=user;
        setTitle("Faculty Main Window");
        // Customize the window for faculty user
        customizeForFaculty(this.user);
    }

    private void customizeForFaculty(User user) {
        // Customize components as needed for faculty user
        JLabel userTypeLabel = new JLabel("Faculty");
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel centerPanel = (JPanel) getContentPane().getComponent(1);
        centerPanel.add(userTypeLabel);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new FacultyWindow(user).showLoginDialog());
//    }
}
