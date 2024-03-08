package ui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import sandbox.CurrentUser;
import sandbox.Database;
import sandbox.LibrarySystem;
import sandbox.User;

public class StudentWindow extends MainWindow {
    private JLabel rentedBooksLabel;
	public static User user;
    public StudentWindow(User user) 
    {
        super();
        this.user=user;
        setTitle("Student Main Window");
        // Customize the window for student user
        customizeForStudent(this.user);
    }

    private void customizeForStudent(User user) {
        // Customize components as needed for student user
        JLabel userTypeLabel = new JLabel("Student");
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel centerPanel = (JPanel) getContentPane().getComponent(1);
        centerPanel.add(userTypeLabel);
        
        rentedBooksLabel = new JLabel("Rented Books:");
        centerPanel.add(rentedBooksLabel);
        if(user.rented.isEmpty())
        {
        	JLabel caution = new JLabel("No Books Rented");
        	centerPanel.add(caution);
        }
        else
        {
        // Display rented books for the current user
        LibrarySystem.displayRentedBooks(StudentWindow.user);
        }
    }

//    public static void main(String[] args) {
//    	Database db = Database.getInstance();
//    	User user = db.getUserByEmail(LoginDialog.getEmailField().getText());
//        CurrentUser.setUserInstance(user);
//        SwingUtilities.invokeLater(() -> new StudentWindow(user).showLoginDialog());
//    }
}
