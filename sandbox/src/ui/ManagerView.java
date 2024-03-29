package ui;

import java.awt.*;
import javax.swing.*;
import sandbox.*;

public class ManagerView extends MainWindow {
  private final LibraryManager libraryManager;

  public ManagerView(LibraryManager manager) {
    setTitle("Library Manager");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 300);
    setLocationRelativeTo(null);

    libraryManager = manager;
    JPanel topPanel = (JPanel) getContentPane().getComponent(0);
    JPanel topRightPanel = (JPanel) topPanel.getComponent(1);
    topRightPanel.remove(0);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(5, 1));

    JButton addItemButton = createAddItemButton();
    JButton enableItemButton = createEnableItemButton();
    JButton disableItemButton = createDisableItemButton();
    JButton deleteItemButton = createDeleteItemButton();
    JButton returnItemButton = createReturnItemButton();
    JButton verifyUserButton = createVerifyUserButton();

    panel.add(addItemButton);
    panel.add(enableItemButton);
    panel.add(disableItemButton);
    panel.add(deleteItemButton);
    panel.add(returnItemButton);
    panel.add(verifyUserButton);

    add(panel, BorderLayout.CENTER);

    // notify for missing newer textbooks
    String missingMsg = LibrarySystem.checkUnavailableNewTextbooks();
    if (!missingMsg.isEmpty()) {
      JOptionPane.showMessageDialog(this, missingMsg);
    }
  }

  private static JButton createVerifyUserButton() {
    JButton verifyUserButton = new JButton("Verify User");
    verifyUserButton.addActionListener(
        e -> {
          // Handle verify user action
          String userId = JOptionPane.showInputDialog(null, "Enter User ID:");
          User user = Database.getUser(userId);

          if (user != null) {
            boolean isVerified = LibraryManager.verify(user);
            Database.updateUserVerification(user.id, isVerified);
            if (isVerified) {
              JOptionPane.showMessageDialog(null, "User Verified successfully");
            } else {
              JOptionPane.showMessageDialog(null, "User not Verfied");
            }
          } else {
            JOptionPane.showMessageDialog(null, "User not found");
          }
        });
    return verifyUserButton;
  }

  private JButton createReturnItemButton() {
    JButton returnItemButton = new JButton("Return Item");
    returnItemButton.addActionListener(
        e -> {
          // Handle delete item action
          String itemId = JOptionPane.showInputDialog(null, "Enter item ID:");
          String userId = JOptionPane.showInputDialog(null, "Enter user ID:");
          // Retrieve the Item object based on the ID (you need to implement this)
          Item item = Database.getItem(itemId);
          User user = Database.getUser(userId);
          if (item != null) {
            // Create a command instance with the Item object
            if (item.copies == 20) {
              JOptionPane.showMessageDialog(null, "Can't exceed Item Capacity");
              return;
            }
            Command returnItemCommand = new ReturnItemCommand(item, user);
            libraryManager.setReturnItemCommand(returnItemCommand);
            // Pass the Item object to the LibraryManager to execute the EnableItemCommand
            libraryManager.returnItem(returnItemCommand);
            JOptionPane.showMessageDialog(null, "Item Deleted successfully");
          } else {
            JOptionPane.showMessageDialog(null, "Item not found");
          }
        });
    return returnItemButton;
  }

  private JButton createDeleteItemButton() {
    JButton deleteItemButton = new JButton("Delete Item");
    deleteItemButton.addActionListener(
        e -> {
          // Handle delete item action
          String itemId = JOptionPane.showInputDialog(null, "Enter item ID:");
          // Retrieve the Item object based on the ID (you need to implement this)
          Item item = Database.getItem(itemId);
          if (item != null) {
            // Create a command instance with the Item object
            Command deleteItemCommand = new DeleteItemCommand(item);
            libraryManager.setDeleteItemCommand(deleteItemCommand);
            // Pass the Item object to the LibraryManager to execute the EnableItemCommand
            libraryManager.deleteItem(deleteItemCommand);
            JOptionPane.showMessageDialog(null, "Item Deleted successfully");
          } else {
            JOptionPane.showMessageDialog(null, "Item not found");
          }
        });
    return deleteItemButton;
  }

  private JButton createDisableItemButton() {
    JButton disableItemButton = new JButton("Disable Item");
    disableItemButton.addActionListener(
        e -> {
          // Handle disable item action
          String itemId = JOptionPane.showInputDialog(null, "Enter item ID:");
          // Retrieve the Item object based on the ID (you need to implement this)
          Item item = Database.getItem(itemId);
          if (item != null) {
            // Create a command instance with the Item object
            Command disableItemCommand = new DisableItemCommand(item);
            libraryManager.setDisableItemCommand(disableItemCommand);
            // Pass the Item object to the LibraryManager to execute the EnableItemCommand
            libraryManager.disableItemForRenting(disableItemCommand);
            JOptionPane.showMessageDialog(null, "Item Disabled for renting successfully");
          } else {
            JOptionPane.showMessageDialog(null, "Item not found");
          }
        });
    return disableItemButton;
  }

  private JButton createEnableItemButton() {
    JButton enableItemButton = new JButton("Enable Item");
    enableItemButton.addActionListener(
        e -> {
          // Handle enable item action
          String itemId = JOptionPane.showInputDialog(null, "Enter item ID:");
          // Retrieve the Item object based on the ID (you need to implement this)
          Item item = Database.getItem(itemId);

          if (item != null) {
            // Create a command instance with the Item object
            Command enableItemCommand = new EnableItemCommand(item);
            libraryManager.setEnableItemCommand(enableItemCommand);
            // Pass the Item object to the LibraryManager to execute the EnableItemCommand
            libraryManager.enableItemForRenting(enableItemCommand);
            JOptionPane.showMessageDialog(null, "Item enabled for renting successfully");
          } else {
            JOptionPane.showMessageDialog(null, "Item not found");
          }
        });
    return enableItemButton;
  }

  private JButton createAddItemButton() {
    JButton addItemButton = new JButton("Add Item");
    addItemButton.addActionListener(
        e -> {
          JTextField nameField = new JTextField();
          JTextField locationField = new JTextField();
          JComboBox<ItemType> typeComboBox = new JComboBox<>(ItemType.values());
          JTextField priceField = new JTextField();
          JComboBox<ItemStatus> statusComboBox = new JComboBox<>(ItemStatus.values());
          JComboBox<ItemPermission> permissionComboBox = new JComboBox<>(ItemPermission.values());
          JTextField categoryField = new JTextField();

          // Create a panel to hold the input fields
          JPanel panel1 = new JPanel(new GridLayout(8, 2));
          panel1.add(new JLabel("Name:"));
          panel1.add(nameField);
          panel1.add(new JLabel("Location:"));
          panel1.add(locationField);
          panel1.add(new JLabel("Type:"));
          panel1.add(typeComboBox);
          panel1.add(new JLabel("Price:"));
          panel1.add(priceField);
          panel1.add(new JLabel("Status:"));
          panel1.add(statusComboBox);
          panel1.add(new JLabel("Permission:"));
          panel1.add(permissionComboBox);
          panel1.add(new JLabel("Category:"));
          panel1.add(categoryField);

          // Show the input dialog to the user
          int result =
              JOptionPane.showConfirmDialog(
                  null,
                  panel1,
                  "Add New Item",
                  JOptionPane.OK_CANCEL_OPTION,
                  JOptionPane.PLAIN_MESSAGE);

          // If the user clicks "OK" and all fields are filled, create a new PhysicalItem
          if (result == JOptionPane.OK_OPTION
              && !nameField.getText().isEmpty()
              && !locationField.getText().isEmpty()
              && !priceField.getText().isEmpty()
              && !categoryField.getText().isEmpty()) {
            String name = nameField.getText();
            String location = locationField.getText();
            ItemType type = (ItemType) typeComboBox.getSelectedItem();
            double price = Double.parseDouble(priceField.getText());
            ItemStatus status = (ItemStatus) statusComboBox.getSelectedItem();
            ItemPermission permission = (ItemPermission) permissionComboBox.getSelectedItem();
            String category = categoryField.getText();

            // Create the new PhysicalItem
            PhysicalItem newItem =
                new PhysicalItem(name, location, type, price, status, permission, category);
            // Pass the newItem to the AddItemCommand
            Command addItemCommand = new AddItemCommand(newItem);
            libraryManager.setAddItemCommand(addItemCommand);
            // Execute the AddItemCommand through the LibraryManager
            libraryManager.addItemToLibrary(addItemCommand);

            JOptionPane.showMessageDialog(null, "Item added successfully");
          } else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
          }
        });
    return addItemButton;
  }
}
