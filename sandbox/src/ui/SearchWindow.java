package ui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import sandbox.CurrentUser;
import sandbox.Database;
import sandbox.Item;
import sandbox.LibrarySystem;

public class SearchWindow extends JFrame {
  // constants
  private static final int WIN_WIDTH = 1024;
  private static final int WIN_HEIGHT = 640;
  private final Database db = Database.getInstance();
  private final LibrarySystem librarySystem = new LibrarySystem();
  private final JTextField searchField = new JTextField(32);
  private JTable table;
  private List<Item> tableItems;

  /** Creates the SearchWindow. */
  public SearchWindow() {
    super("Search Library");

    // init window
    this.setLayout(new BorderLayout());
    this.setSize(WIN_WIDTH, WIN_HEIGHT);
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    // center window
    Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(
        (screenDimension.width - WIN_WIDTH) / 2, (screenDimension.height - WIN_HEIGHT) / 2);

    // add panels
    this.add(createTopPanel(), BorderLayout.NORTH);
    this.add(createCenterPanel(), BorderLayout.CENTER);
    this.add(createBottomPanel(), BorderLayout.SOUTH);
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
    this.searchField.setRequestFocusEnabled(true);
    rightPanel.add(this.searchField);

    JButton searchButton = new JButton("Search");
    searchButton.addActionListener(e -> searchAction());
    rightPanel.add(searchButton);

    JButton clearButton = new JButton("Clear");
    clearButton.addActionListener(e -> clearSearch());
    rightPanel.add(clearButton);

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
    tableItems = db.getAllItems();
    this.table = new JTable(new ItemTableModel(this.tableItems));
    this.table.setFillsViewportHeight(true);
    this.table.setPreferredScrollableViewportSize(
        new Dimension(WIN_WIDTH - 36, WIN_HEIGHT - 160)); // padding_x: 18px

    JScrollPane scrollPane = new JScrollPane(table);

    // add panel
    centerPanel.add(scrollPane);
    return centerPanel;
  }

  /**
   * Creates the SearchWindows's secondary actions/bottom panel.
   *
   * @return JPanel
   */
  private JPanel createBottomPanel() {
    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
    bottomPanel.setBorder(new EmptyBorder(4, 12, 4, 12));

    // add content
    JButton purchaseButton = new JButton("Purchase Item");
    purchaseButton.addActionListener(e -> purchaseAction());
    bottomPanel.add(purchaseButton);

    JButton rentButton = new JButton("Rent Item");
    rentButton.addActionListener(e -> rentAction());
    bottomPanel.add(rentButton);

    // add panel
    return bottomPanel;
  }

  private void clearSearch() {
    // Clear the search field
    searchField.setText("");
    // Reset the table with all items
    table.setModel(new ItemTableModel(db.getAllItems()));
  }

  private void searchAction() {
    // Get the search query from the text field
    String query = searchField.getText();

    // reset table on empty search
    if (Objects.equals(query, "")) {
      this.tableItems = db.getAllItems();
      table.setModel(new ItemTableModel(this.tableItems));
      return;
    }

    // Call the searchItem method in LibrarySystem
    Item foundItem = librarySystem.searchItem(query);
    // Handle the foundItem as needed
    if (foundItem != null) {
      // Item found, do something
      List<Item> recommendations = librarySystem.getRecommendations(foundItem.category);

      List<Item> results = new ArrayList<>();
      results.add(foundItem);
      results.addAll(recommendations);
      this.tableItems = results;
      table.setModel(new ItemTableModel(this.tableItems));

      JOptionPane.showMessageDialog(this, "Item Found: " + foundItem.name);
    } else {
      // Item not found, display a message
      this.tableItems = db.getAllItems();
      table.setModel(new ItemTableModel(this.tableItems));
      JOptionPane.showMessageDialog(this, "Item not found.");
    }
  }

  private void purchaseAction() {
    int selectedRow = this.table.getSelectedRow();
    if (selectedRow == -1) {
      JOptionPane.showMessageDialog(this, "No item selected");
      return;
    }

    Item item = tableItems.get(selectedRow);
    // check first permission bit (purchasing)
    if (((item.permission.getValue() >> 1) & 1) == 0) {
      JOptionPane.showMessageDialog(this, "This item cannot be purchased");
      return;
    }

    String msg = librarySystem.BuyItem(item, null, CurrentUser.getUserInstance());
    JOptionPane.showMessageDialog(this, msg);
  }

  private void rentAction() {
    int selectedRow = this.table.getSelectedRow();
    if (selectedRow == -1) {
      JOptionPane.showMessageDialog(this, "No item selected");
      return;
    }

    Item item = tableItems.get(selectedRow);
    // check last permission bit (renting bit)
    if ((item.permission.getValue() & 1) == 0) {
      JOptionPane.showMessageDialog(this, "This item cannot be rented");
      return;
    }

    String msg = librarySystem.RentItem(item, CurrentUser.getUserInstance());
    JOptionPane.showMessageDialog(this, msg);
  }
}
