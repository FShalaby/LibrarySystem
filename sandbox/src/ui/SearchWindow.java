package ui;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import sandbox.*;

public class SearchWindow extends JFrame {
  // constants
  protected final User currentUser = CurrentUser.getUserInstance();
  private static final int WIN_WIDTH = 1024;
  private static final int WIN_HEIGHT = 640;
  private final Database db = Database.getInstance();
  private final LibrarySystem librarySystem = new LibrarySystem();
  private final JTextField searchField = new JTextField(32);
  private JTable table;
  private List<Item> tableItems;
  private final MainWindow parent;

  /** Creates the SearchWindow. */
  public SearchWindow(MainWindow parent) {
    super("Search Library");

    // set attributes
    this.parent = parent;

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

  /** Disposes of the parent window (MainWindow) and creates a new one */
  private void backAction() {
    // recreate parent window from scratch
    if (this.parent instanceof StudentWindow) {
      new StudentWindow().setVisible(true);
    } else {
      new MainWindow().setVisible(true);
    }

    this.parent.dispose();
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

    // Open the payment form
    PaymentForm paymentForm = new PaymentForm(this, item);
    paymentForm.setVisible(true);
  }

  public class PaymentForm extends JFrame {
    private final Item item;
    private final JTextField bookNameField;
    private final JTextField priceField;
    private final JComboBox<String> paymentComboBox;

    public PaymentForm(JFrame parent, Item item) {
      super("Payment Form");
      this.item = item;

      // Initialize UI components for payment form
      JLabel bookNameLabel = new JLabel("Book Name:");
      bookNameField = new JTextField(20);
      bookNameField.setText(item.name);
      bookNameField.setEditable(false);

      JLabel priceLabel = new JLabel("Price:");
      priceField = new JTextField(10);
      priceField.setText(String.valueOf(item.price));
      priceField.setEditable(false);
      JLabel paymentLabel = new JLabel("Select Payment Method:");
      paymentComboBox = new JComboBox<>(new String[] {"Debit", "Credit", "Mobile"});

      JButton processPaymentButton = new JButton("Process Payment");
      processPaymentButton.addActionListener(e -> processPayment());

      // Add UI components to the payment form
      JPanel panel = new JPanel(new GridLayout(4, 2));
      panel.add(bookNameLabel);
      panel.add(bookNameField);
      panel.add(priceLabel);
      panel.add(priceField);
      panel.add(paymentLabel);
      panel.add(paymentComboBox);

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(processPaymentButton);

      getContentPane().setLayout(new BorderLayout());
      getContentPane().add(panel, BorderLayout.CENTER);
      getContentPane().add(buttonPanel, BorderLayout.SOUTH);

      setSize(300, 200);
      setLocationRelativeTo(parent);
    }

    private void processPayment() {
      // Retrieve payment information from the form
      String bookName = bookNameField.getText();
      double price = Double.parseDouble(priceField.getText());
      String selectedPayment = (String) paymentComboBox.getSelectedItem();
      if (selectedPayment != null) {
        Payment payment = null;
        // Call BuyItem method with the appropriate parameters
        switch (selectedPayment.toLowerCase()) {
          case "debit":
            payment = new DebitCardPayment();
            break;
          case "credit":
            payment = new CreditCardPayment();
            break;
          case "mobile":
            payment = new MobileWalletPayment();
            break;
          default:
            JOptionPane.showMessageDialog(this, "Invalid payment method selected");
            break;
        }
        if (payment != null) {
          librarySystem.BuyItem(item, payment, currentUser);
          JOptionPane.showMessageDialog(this, "Item Purchased Successfully");
        } else {
          JOptionPane.showMessageDialog(this, "Failed to process payment. Please try again.");
        }
      } else {
        JOptionPane.showMessageDialog(this, "Please select a payment method");
      }

      // Close the payment form
      dispose();
    }
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
