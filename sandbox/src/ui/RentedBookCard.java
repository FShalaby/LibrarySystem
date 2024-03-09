package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import sandbox.Item;

public class RentedBookCard extends JPanel {
  public RentedBookCard(Item book) {
    this.setLayout(new BorderLayout());
    this.setBackground(Color.WHITE);
    this.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Border for each book panel

    JPanel textPanel = createTextPanel(book);
    this.add(textPanel, BorderLayout.CENTER);

    // add padding and border
    Border border =
        BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY);
    Border padding = BorderFactory.createEmptyBorder(8, 8, 8, 8);
    Border compound = BorderFactory.createCompoundBorder(border, padding);
    this.setBorder(compound);

    // set background to white
    this.setBackground(Color.WHITE);
  }

  private static JPanel createTextPanel(Item book) {
    JLabel titleLabel = new JLabel(book.name); // Use book name
    titleLabel.setFont(new Font(titleLabel.getFont().getFontName(), Font.BOLD, 12));

    JLabel DueDate = new JLabel("Due Date: " + book.dueDate); // Use book location
    JLabel statusLabel = new JLabel("Status: " + book.status); // Use book status
    JLabel categoryLabel = new JLabel("Category: " + book.category); // Use book category

    JPanel textPanel = new JPanel(new BorderLayout());
    textPanel.add(titleLabel, BorderLayout.NORTH);
    textPanel.add(DueDate, BorderLayout.CENTER);
    textPanel.add(statusLabel, BorderLayout.SOUTH);
    textPanel.add(categoryLabel, BorderLayout.SOUTH);

    textPanel.setBackground(Color.WHITE);
    return textPanel;
  }
}
