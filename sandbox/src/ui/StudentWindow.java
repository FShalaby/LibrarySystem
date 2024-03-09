package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import sandbox.CurrentUser;
import sandbox.Database;
import sandbox.Item;
import sandbox.LibrarySystem;
import sandbox.User;

public class StudentWindow extends MainWindow {
    private JLabel rentedBooksLabel;
	public static User user;
    public StudentWindow(User user) 
    {
        super();
        this.user=user;
        setTitle("Student Window");
        // Customize the window for student user
        customizeForStudent(this.user);
    }

    private void customizeForStudent(User user) {
        JLabel userTypeLabel = new JLabel("Student");
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel centerPanel = (JPanel) getContentPane().getComponent(1);
        centerPanel.setLayout(new BorderLayout());

        centerPanel.add(userTypeLabel, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JPanel cardPanel = new JPanel(new CardLayout());
        leftPanel.add(cardPanel);
        if(user.rented.isEmpty())
        {
        	 rentedBooksLabel = new JLabel("Rented Books:");
             leftPanel.add(rentedBooksLabel);
        }
        for (Item book : user.rented) {
            JPanel bookPanel = createBookPanel(book);
            cardPanel.add(bookPanel);
        }

        leftPanel.setBackground(Color.WHITE);
        // Create a border for the rented books section
        Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.LIGHT_GRAY);
        Border margin = BorderFactory.createEmptyBorder(10, 10, 10, 10); // Adjust margin values here
        Border compound = BorderFactory.createCompoundBorder(border, margin);
        leftPanel.setBorder(compound);

        centerPanel.add(leftPanel, BorderLayout.WEST);
    }
    
    private JPanel createBookPanel(Item book) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Border for each book panel

        JLabel titleLabel = new JLabel(book.name); // Use book name
        JLabel DueDate = new JLabel("Due Date: " + book.dueDate); // Use book DueDate
        JLabel statusLabel = new JLabel("Status: " + book.status); // Use book status
        JLabel categoryLabel = new JLabel("Category: " + book.category); // Use book category

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(titleLabel, BorderLayout.NORTH);
        textPanel.add(DueDate, BorderLayout.CENTER);
        textPanel.add(statusLabel, BorderLayout.SOUTH);
        textPanel.add(categoryLabel, BorderLayout.SOUTH);
        

        panel.add(textPanel, BorderLayout.CENTER);

        return panel;
    }

//    public static void main(String[] args) {
//    	Database db = Database.getInstance();
//    	User user = db.getUserByEmail(LoginDialog.getEmailField().getText());
//        CurrentUser.setUserInstance(user);
//        SwingUtilities.invokeLater(() -> new StudentWindow(user).showLoginDialog());
//    }
}
