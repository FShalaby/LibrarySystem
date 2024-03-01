package ui;

import sandbox.Database;
import sandbox.User;
import sandbox.UserFactory;

import java.awt.*;
import javax.swing.*;

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
    this.userTypeComboBox.setPrototypeDisplayValue("_".repeat(48));

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

    // Create user based on selected user type
    User newUser = UserFactory.createUser(name, email, pass, selectedUserType);
    if (!newUser.isVerified) {
      JOptionPane.showMessageDialog(
          this, "Verification Required. Please wait while we check your information.");
      return; // Stop signup process
    }

    // return to login dialog
    showLoginDialog();
  }

  /** Creates and shows login dialog, disposes self */
  private void showLoginDialog() {
    this.mainWindow.showLoginDialog();
    this.dispose();
  }
}
