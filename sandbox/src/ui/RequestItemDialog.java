package ui;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import javax.swing.*;
import sandbox.ItemRequest;
import sandbox.ItemType;
import sandbox.LibrarySystem;

public class RequestItemDialog extends JFrame {
  // constants
  private static final int WIN_WIDTH = 448;
  private static final int WIN_HEIGHT = 384;

  // attributes
  private final JTextField nameField = new JTextField(30);
  private final JTextField isbnField = new JTextField(30);
  private final JTextField infoField = new JTextField(24);
  private final JComboBox<String> typeComboBox;
  private final JComboBox<String> reasonComboBox;

  public RequestItemDialog() {
    super("Request Item");
    this.setVisible(false);
    this.setLayout(new BorderLayout());
    this.setResizable(false);
    this.setSize(WIN_WIDTH, WIN_HEIGHT);
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    ArrayList<String> itemTypes = new ArrayList<>();
    for (ItemType i : ItemType.values()) {
      itemTypes.add(i.toString());
    }

    // create combo box, lock to textbook
    this.typeComboBox = new JComboBox<>(itemTypes.toArray(new String[] {}));
    this.typeComboBox.setSize(320, 20);
    this.typeComboBox.setPrototypeDisplayValue(String.join("", Collections.nCopies(44, "_")));
    this.typeComboBox.setSelectedItem(ItemType.Textbook.toString());
    this.typeComboBox.setEnabled(false);

    this.reasonComboBox =
        new JComboBox<>(
            new String[] {"Course Teaching", "Self-Improvement", "Other (please specify)"});
    this.reasonComboBox.setSize(320, 20);
    this.reasonComboBox.setPrototypeDisplayValue(String.join("", Collections.nCopies(44, "_")));

    this.add(createCenterPanel(), BorderLayout.CENTER);
    this.add(createBottomPanel(), BorderLayout.SOUTH);
  }

  private JPanel createCenterPanel() {
    FormPanel panel = new FormPanel();

    JLabel nameLabel = new JLabel("Name:");
    JLabel typeLabel = new JLabel("Type:");
    JLabel isbnLabel = new JLabel("ISBN:");
    JLabel reasonLabel = new JLabel("Reason:");
    JLabel infoLabel = new JLabel("Additional Info:");

    panel.addRow(nameLabel, nameField);
    panel.addRow(typeLabel, typeComboBox);
    panel.addRow(isbnLabel, isbnField);
    panel.addRow(reasonLabel, reasonComboBox);
    panel.addRow(infoLabel, infoField);

    return panel;
  }

  private JPanel createBottomPanel() {
    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

    JButton cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(e -> this.dispose());
    bottomPanel.add(cancelButton);

    JButton confirmButton = new JButton("Confirm");
    confirmButton.addActionListener(e -> confirmAction());
    bottomPanel.add(confirmButton);

    return bottomPanel;
  }

  private void confirmAction() {
    String name = this.nameField.getText();
    if (name.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Please give a name for the requested item.");
      return;
    }

    String isbn = this.isbnField.getText();
    if (isbnField.isVisible() && isbn.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Please give the ISBN for the requested item.");
      return;
    }

    String type = ((String) Objects.requireNonNull(typeComboBox.getSelectedItem()));
    ItemType itemType = ItemType.Unknown;
    for (ItemType i : ItemType.values()) {
      if ((type).equalsIgnoreCase(i.toString())) {
        itemType = i;
        break;
      }
    }

    String reason =
        ((String) Objects.requireNonNull(reasonComboBox.getSelectedItem())).toLowerCase();
    String additionalInfo = this.infoField.getText();

    String msg = LibrarySystem.submitItemRequest(new ItemRequest(name, itemType, isbn, reason, additionalInfo));
    JOptionPane.showMessageDialog(this, msg);
    this.dispose();
  }
}
