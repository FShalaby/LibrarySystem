package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import sandbox.CurrentUser;
import sandbox.User;

/** The main entrypoint for the GUI. */
public class MainWindow extends JFrame {
  // constants
  private static final int WIN_WIDTH = 1024;
  private static final int WIN_HEIGHT = 640;

  // attributes
  private final SearchWindow searchWindow = new SearchWindow();
  private final User currentUser = CurrentUser.getUserInstance();

  /** Creates the MainWindow. */
  protected MainWindow() {
    super("Library System");

    // init window
    this.setLayout(new BorderLayout());
    this.setSize(WIN_WIDTH, WIN_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // center window
    Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(
        (screenDimension.width - WIN_WIDTH) / 2, (screenDimension.height - WIN_HEIGHT) / 2);

    // add panels
    this.add(createTopPanel(), BorderLayout.NORTH);
    this.add(createCenterPanel(), BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new MainWindow().showLoginDialog());
  }

  /** Creates and displays a login dialog. */
  public void showLoginDialog() {
    // login dialog always disposes itself
    LoginDialog loginDialog = new LoginDialog(this);
    loginDialog.setVisible(true);
    this.setVisible(false);
    this.searchWindow.setVisible(false);
  }

  /** Displays a search window. */
  public void showSearchWindow() {
    this.searchWindow.setVisible(true);
  }

  /**
   * Creates the MainWindow's navigation/top panel.
   *
   * @return JPanel
   */
  private JPanel createTopPanel() {
    JPanel topPanel = new JPanel();
    topPanel.setLayout(new GridLayout(1, 2));
    topPanel.setBorder(new EmptyBorder(4, 6, 4, 6));

    // split top panel into left and right sides
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

    // left panel content
    JLabel greeter = new JLabel("Welcome, " + (currentUser != null ? currentUser.name : "UNKNOWN"));
    greeter.setBorder(new EmptyBorder(5, 0, 5, 0));
    leftPanel.add(greeter);

    // right panel content
    JButton searchButton = new JButton("Search Library");
    searchButton.addActionListener(e -> showSearchWindow());
    rightPanel.add(searchButton);

    JButton logoutButton = new JButton("Logout");
    logoutButton.addActionListener(e -> showLoginDialog());
    rightPanel.add(logoutButton);

    // add panels
    topPanel.add(leftPanel);
    topPanel.add(rightPanel);
    return topPanel;
  }

  /**
   * Creates the MainWindow's main/centered panel.
   *
   * @return JPanel
   */
  private JPanel createCenterPanel() {
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
    centerPanel.setBorder(new EmptyBorder(12, 12, 12, 12));

    // add content
    JLabel label = new JLabel("Main Page");

    // add panel
    centerPanel.add(label);
    return centerPanel;
  }
}
