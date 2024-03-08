package ui;

import java.awt.*;
import java.util.Map;
import javax.swing.*;
import sandbox.CurrentUser;
import sandbox.Database;
import sandbox.User;

/** Class that renders a login dialog. Disposes of itself on close. */
public class LoginDialog extends JFrame {
  // constants
  private static final int WIN_WIDTH = 512;
  private static final int WIN_HEIGHT = 192;

  // attributes
  private final MainWindow mainWindow;
  private final Database db = Database.getInstance();
  private final JTextField emailField = new JTextField(32);
  private final JPasswordField passField = new JPasswordField(32);

  /**
   * Creates the LoginDialog. Disposes of itself on close.
   *
   * @param mainWindow the app's main window
   */
  public LoginDialog(MainWindow mainWindow) {
    super("Login");

    // set attributes
    this.mainWindow = mainWindow;

    // initialize dialog
    this.setResizable(false);
    this.setSize(WIN_WIDTH, WIN_HEIGHT);
    this.add(createLoginForm());
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // not needed once closed

    // center dialog
    Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(
        (screenDimension.width - WIN_WIDTH) / 2, (screenDimension.height - WIN_HEIGHT) / 2);
  }

  /**
   * Creates a FormPanel containing the necessary fields and actions for logging in.
   *
   * @return FormPanel
   */
  private FormPanel createLoginForm() {
    JLabel emailLabel = new JLabel("Email:");
    JLabel passLabel = new JLabel("Password:");

    JButton closeButton = new JButton("Close");
    closeButton.addActionListener(e -> System.exit(0));

    JButton signupButton = new JButton("Signup");
    signupButton.addActionListener(e -> showSignupDialog());

    JButton loginButton = new JButton("Login");
    loginButton.addActionListener(e -> loginAction());

    JPanel spacer = new JPanel();
    spacer.setSize(20, 1);

    FormPanel formPanel = new FormPanel();
    formPanel.addRow(emailLabel, emailField);
    formPanel.addRow(passLabel, passField);
    formPanel.addVSpace(12);
    formPanel.addActions(closeButton, spacer, signupButton, loginButton);

    return formPanel;
  }

  /** Primary action associated with clicking the Login button. */
  private void loginAction() {
    String email = emailField.getText();
    String pass = new String(passField.getPassword());

    // Check if email and password match records in the CSV file
    Map<String, String> users = db.getAllUsersMap();
    if (!users.containsKey(email) || !users.get(email).equals(pass)) {
      JOptionPane.showMessageDialog(this, "Invalid email or password");
      return;
    }

    // set current user
    User user = db.getUserByEmail(email);
    CurrentUser.setUserInstance(user);

    // TODO: check user is verified
    //        if () {}
    
    String userType = Database.getUserType(email);
    if (userType == null) {
        JOptionPane.showMessageDialog(this, "Failed to retrieve user type");
        return;
    }
    switch (userType.toLowerCase()) {
    case "student":
        new StudentWindow().setVisible(true);
        break;
    case "faculty":
        new FacultyWindow().setVisible(true);
        break;
    case "non-faculty":
        new NonFacultyWindow().setVisible(true);
        break;
    case "visitor":
        new VisitorWindow().setVisible(true);
        break;
    default:
        JOptionPane.showMessageDialog(this, "Unknown user type");
        break;
}

    JOptionPane.showMessageDialog(this, "Login successful!");
    this.dispose();
//    JOptionPane.showMessageDialog(this, "Login successful!");
//    this.mainWindow.setVisible(true);
//    this.dispose();
  }

  /** Creates and displays a signup dialog. */
  private void showSignupDialog() {
    // signup dialog should always dispose of itself
    SignupDialog signupDialog = new SignupDialog(mainWindow);
    signupDialog.setVisible(true);
    this.setVisible(false);
  }
}
