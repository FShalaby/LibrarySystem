package ui;

import java.awt.*;

import sandbox.*;
import ui.ManagerView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.*;

/** Class that renders a login dialog. Disposes of itself on close. */
public class LoginDialog extends JFrame {
  // constants
  private static final int WIN_WIDTH = 512;
  private static final int WIN_HEIGHT = 192;

  // attributes
  private final MainWindow mainWindow;
  private final Database db = Database.getInstance();
  private static final JTextField emailField = new JTextField(32);
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

    //    JButton ManagerLogin = new JButton("Admin Login");
    //    ManagerLogin.addActionListener(e -> ManagerLogin());

    JButton signupButton = new JButton("Signup");
    signupButton.addActionListener(e -> showSignupDialog());

    JButton loginButton = new JButton("Login");
    loginButton.addActionListener(e -> loginAction());

    JPanel spacer = new JPanel();
    spacer.setSize(20, 1);

    FormPanel formPanel = new FormPanel();
    formPanel.addRow(emailLabel, getEmailField());
    formPanel.addRow(passLabel, passField);
    formPanel.addVSpace(12);
    formPanel.addActions(closeButton, spacer, signupButton, loginButton);

    return formPanel;
  }

  //  private void ManagerLogin() {
  //	  String email = getEmailField().getText();
  //	    String pass = new String(passField.getPassword());
  //
  //
  //	    User manager = Database.getUserByEmail(email)
  //
  //	    if (!email.equals(Database.getUserByEmail(email)) ||
  // !pass.equals(Database.getPasswordByEmail(email))) {
  //	        JOptionPane.showMessageDialog(this, "Invalid email or password");
  //	        return;
  //	    }
  //
  //	    // Open ManagerView
  //	    ManagerView managerView = new ManagerView(manager);
  //	    managerView.setVisible(true);
  //	    this.dispose();
  //
  //	    JOptionPane.showMessageDialog(this, "Login successful!");
  ////	    JOptionPane.showMessageDialog(this, "Login successful!");
  ////	    this.mainWindow.setVisible(true);
  ////	    this.dispose();
  //	  }

  /** Primary action associated with clicking the Login button. */
  private void loginAction() {
    String email = getEmailField().getText();
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

    if (user == null || user.type == null) {
      JOptionPane.showMessageDialog(this, "Failed to retrieve user type");
      return;
    }

    if (!user.isVerified) {
      JOptionPane.showMessageDialog(this, "Login Failed! Verification needed");
      return;
    }

    // auto-return due online items
    ArrayList<RentedItem> rentals = (ArrayList<RentedItem>) db.getUserRentals(user.id);
    for (RentedItem rental : rentals) {
      if (!rental.getItem().location.equalsIgnoreCase("online")) {
        continue;
      }

      if (rental.getDueDate().isBefore(LocalDate.now())) {
        db.deleteRental(rental.getItem().id, rental.getUserID());
        rentals.remove(rental);
      }
    }

    CurrentUser.getUserInstance().setRentedItems(rentals);

    switch (user.type.toLowerCase()) {
      case "student":
        new StudentWindow().setVisible(true);
        break;
      case "faculty":
        new FacultyWindow().setVisible(true);
        break;
      case "non-faculty":
        new NonFacultyWindow(user).setVisible(true);
        break;
      case "visitor":
        new VisitorWindow(user).setVisible(true);
        break;
      case "manager":
        new ManagerView((LibraryManager) user).setVisible(true);
        break;
      default:
        JOptionPane.showMessageDialog(this, "Unknown user type");
        break;
    }

    this.dispose();
  }

  /** Creates and displays a signup dialog. */
  private void showSignupDialog() {
    // signup dialog should always dispose of itself
    SignupDialog signupDialog = new SignupDialog(mainWindow);
    signupDialog.setVisible(true);
    this.setVisible(false);
  }

  public static JTextField getEmailField() {
    return emailField;
  }
}
