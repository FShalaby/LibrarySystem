package sandbox;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class LoginGUI extends JFrame implements ActionListener {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton; // New sign-up button
    
    private Map<String, String> users; // Map to store email-password pairs
    
    public LoginGUI() {
        setTitle("Login");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1)); // Increased the row count
        
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        
        signupButton = new JButton("Sign Up"); // Initialize sign-up button
        signupButton.addActionListener(this); // Add action listener
        
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signupButton); // Add sign-up button
        
        add(panel);
        
        // Read user credentials from CSV file
        users = readUserCredentials("/Users/fouadshalaby/Desktop/user.csv"); // Modified CSV file path
        
        setVisible(true);
    }
    
    private Map<String, String> readUserCredentials(String filename) {
        Map<String, String> userMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) { // Ensure at least four columns exist
                    String email = parts[2].trim(); // Email is in the third column
                    String password = parts[3].trim(); // Password is in the fourth column
                    userMap.put(email, password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userMap;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            
            // Check if email and password match records in the CSV file
            if (users.containsKey(email) && users.get(email).equals(password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                
                // Open another page (dummy page)
                new AnotherPage();
                
                // Close the login page
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password");
            }
        } else if (e.getSource() == signupButton) { // Handle sign-up button click
            // Open sign-up GUI
            new SignupGUI();
        }
    }
    
    public static void main(String[] args) {
        new LoginGUI();
    }


class AnotherPage extends JFrame {
    public AnotherPage() {
        setTitle("Another Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel label = new JLabel("Welcome to Another Page!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        
        add(label);
        setVisible(true);
    }
}

class SignupGUI extends JFrame {
	 private JTextField nameField;
	    private JTextField emailField;
	    private JPasswordField passwordField;
	    private JButton signupButton;

	    String[] userTypes = {"student", "faculty", "non-faculty", "visitor"};
	    JComboBox<String> userTypeComboBox = new JComboBox<>(userTypes);

	    public SignupGUI() {
	        setTitle("Sign Up");
	        setSize(300, 300);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close

	        JPanel panel = new JPanel();
	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Set layout to BoxLayout with Y_AXIS alignment

	        JLabel nameLabel = new JLabel("Name:");
	        nameField = new JTextField(20); // Set preferred width
	        panel.add(nameLabel);
	        panel.add(nameField);

	        JLabel emailLabel = new JLabel("Email:");
	        emailField = new JTextField(20); // Set preferred width
	        panel.add(emailLabel);
	        panel.add(emailField);

	        JLabel passwordLabel = new JLabel("Password:");
	        passwordField = new JPasswordField(20); // Set preferred width
	        panel.add(passwordLabel);
	        panel.add(passwordField);

	        JLabel userTypeLabel = new JLabel("User Type:");
	        panel.add(userTypeLabel);
	        panel.add(userTypeComboBox);

	        signupButton = new JButton("Sign Up");
	        signupButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Retrieve user input
	                String name = nameField.getText();
	                String email = emailField.getText();
	                String password = new String(passwordField.getPassword());
	                String selectedUserType = (String) userTypeComboBox.getSelectedItem();

	                // Create user based on selected user type
	                User newUser = UserFactory.createUser(name, email, password, selectedUserType);
	                
//	                if (!newUser.vertification) {
//	                    JOptionPane.showMessageDialog(SignupGUI.this, "Verification Required. Please wait while we check your information.");
//	                    return; // Stop signup process
//	                }

	                users = readUserCredentials("/Users/fouadshalaby/Desktop/user.csv");

	                // Close the sign-up GUI
	                dispose();
	            }
	        });
	        panel.add(signupButton);

	        add(panel);
	        setVisible(true);
    }
}
    
//    private void writeUserData(String name, String email, String password) {
//        String csvFilePath = "/Users/fouadshalaby/Desktop/user.csv"; // Path to your CSV file
//        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
//            String lastLine = null;
//            String line;
//            while ((line = reader.readLine()) != null) {
//                lastLine = line; // Keep track of the last line in the CSV
//            }
//            int lastId = 0;
//            if (lastLine != null) {
//                String[] parts = lastLine.split(",");
//                if (parts.length >= 2) { // Ensure at least two columns exist
//                    lastId = Integer.parseInt(parts[1]); // Assuming ID is the second column
//                }
//            }
//            
//            // Increment the last ID
//            int newId = lastId + 1;
//
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath, true))) {
//                // Append user data to the CSV file
//            	writer.newLine();
//                writer.write(String.format("%s,%d,%s,%s%n", name, newId, email, password)); // Assuming ID is the second column
//                System.out.println("User data has been written to the CSV file.");
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

}
