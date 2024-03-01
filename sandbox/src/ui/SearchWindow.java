package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SearchWindow extends JFrame {
  // constants
  private static final int WIN_WIDTH = 1024;
  private static final int WIN_HEIGHT = 640;

  /** Creates the SearchWindow. */
  public SearchWindow() {
    super("Search Library");

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

  private void backAction() {
    this.setVisible(false);
  }

  /**
   * Creates the SearchWindows's navigation/top panel.
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
    JButton backButton = new JButton("Back");
    backButton.addActionListener(e -> backAction());
    leftPanel.add(backButton);

    // right panel content
    JTextField searchField = new JTextField(32);
    searchField.setRequestFocusEnabled(true);
    rightPanel.add(searchField);

    JButton searchButton = new JButton("Search");
    searchButton.addActionListener(
        e -> System.out.println("Search Query: " + searchField.getText()));
    rightPanel.add(searchButton);

    // add panels
    topPanel.add(leftPanel);
    topPanel.add(rightPanel);
    return topPanel;
  }

  /**
   * Creates the SearchWindows's main/centered panel.
   *
   * @return JPanel
   */
  private JPanel createCenterPanel() {
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
    centerPanel.setBorder(new EmptyBorder(12, 12, 12, 12));

    // add content
    JLabel label = new JLabel("Search Page");

    // add panel
    centerPanel.add(label);
    return centerPanel;
  }
}
