package ui;

import java.awt.*;
import java.util.Collections;
import javax.swing.*;
import sandbox.Database;
import sandbox.LibraryManager;
import sandbox.User;
import sandbox.UserFactory;

import java.util.ArrayList;
import java.util.List;

/** Class that renders a signup dialog. Disposes of itself on close. */
public class SignupDialog extends JFrame {
  // constants
  private static final int WIN_WIDTH = 512;
  private static final int WIN_HEIGHT = 288;

  // attributes
  private final MainWindow mainWindow;
  private final JTextField nameField = new JTextField(32);
  private final JTextField emailField = new JTextField(32);
  private final JPasswordField passField = new JPasswordField(32);
  private final JComboBox<String> userTypeComboBox;

  /**
   * Creates a SignupDialog. Disposes of itself on close.
   *
   * @param mainWindow the app's main window
   */
  public SignupDialog(MainWindow mainWindow) {
    super("Signup");

    // set attributes
    this.mainWindow = mainWindow;

    // init form fields
    String[] userTypes = new String[] {"Student", "Faculty", "Non-Faculty", "Visitor"};
    this.userTypeComboBox = new JComboBox<>(userTypes);
    this.userTypeComboBox.setSize(384, 20);
    this.userTypeComboBox.setPrototypeDisplayValue(String.join("", Collections.nCopies(48, "_")));

    // init dialog
    this.setResizable(false);
    this.setSize(WIN_WIDTH, WIN_HEIGHT);
    this.add(createSignupForm());
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // not needed once closed

    // center dialog
    Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(
        (screenDimension.width - WIN_WIDTH) / 2, (screenDimension.height - WIN_HEIGHT) / 2);
  }

  /**
   * Creates a FormPanel containing the necessary fields and actions for signing up.
   *
   * @return FormPanel
   */
  private FormPanel createSignupForm() {
    JLabel nameLabel = new JLabel("Name:");
    JLabel emailLabel = new JLabel("Email:");
    JLabel passLabel = new JLabel("Password:");

    JLabel typeLabel = new JLabel("User Type:");

    JButton backButton = new JButton("Back to Login");
    backButton.addActionListener(e -> showLoginDialog());

    JButton signupButton = new JButton("Signup");
    signupButton.addActionListener(e -> signupAction());

    JPanel spacer = new JPanel();
    spacer.setSize(20, 1);

    FormPanel formPanel = new FormPanel();
    formPanel.addRow(nameLabel, this.nameField);
    formPanel.addRow(emailLabel, this.emailField);
    formPanel.addRow(passLabel, this.passField);
    formPanel.addRow(typeLabel, this.userTypeComboBox);
    formPanel.addVSpace(12);
    formPanel.addActions(backButton, spacer, signupButton);

    return formPanel;
  }

  private void signupAction() {
    // Retrieve user input
    String name = nameField.getText();
    String email = emailField.getText();
    String pass = new String(passField.getPassword());
    String selectedUserType = (String) userTypeComboBox.getSelectedItem();
    if (selectedUserType == null) {
      JOptionPane.showMessageDialog(this, "Please choose a login type");
      return;
    }
    selectedUserType = selectedUserType.toLowerCase();

    Database db = Database.getInstance();

    // prevent duplicate signup
    if (db.getUserByEmail(email) != null) {
      JOptionPane.showMessageDialog(this, "User with email '" + email + "' already exists");
      return;
    }
    
 // Check password strength
    List<String> passwordErrors = checkPasswordStrength(pass);
    if (!passwordErrors.isEmpty()) {
        StringBuilder errorMessage = new StringBuilder("Password requirements not met:\n");
        for (String error : passwordErrors) {
            errorMessage.append("- ").append(error).append("\n");
        }
        JOptionPane.showMessageDialog(this, errorMessage.toString());
        return;
    }

    System.out.println(name + "; " + email + "; " + pass + "; " + selectedUserType);

    // Create a new user based on selected type
    User newUser = UserFactory.createUser(name, email, pass, selectedUserType, false);
    newUser.writeUserCsv();

   if(selectedUserType.toLowerCase() != "visitor")
   {
	  JOptionPane.showMessageDialog(this,"Signup Successful! please wait until verified");

   }

    db.getAllUsersMap();
    // return to login dialog
    showLoginDialog();
  }
  private List<String> checkPasswordStrength(String password) {
	    List<String> errors = new ArrayList<>();

	    // Check if password is at least 8 characters long
	    if (password.length() < 8) {
	        errors.add("Password must be at least 8 characters long");
	    }

	    // Check if password contains at least one uppercase letter
	    if (!password.matches(".*[A-Z].*")) {
	        errors.add("Password must contain at least one uppercase letter");
	    }

	    // Check if password contains at least one lowercase letter
	    if (!password.matches(".*[a-z].*")) {
	        errors.add("Password must contain at least one lowercase letter");
	    }

	    // Check if password contains at least one digit
	    if (!password.matches(".*\\d.*")) {
	        errors.add("Password must contain at least one digit");
	    }

	    // Check if password contains at least one special character
	    if (!password.matches(".*[@#$%^&+=].*")) {
	        errors.add("Password must contain at least one special character");
	    }

	    return errors;
	}


  /** Creates and shows login dialog, disposes self */
  private void showLoginDialog() {
    this.mainWindow.showLoginDialog();
    this.dispose();
  }
}
