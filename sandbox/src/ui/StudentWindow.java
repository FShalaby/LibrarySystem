package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import sandbox.Database;
import sandbox.Item;

public class StudentWindow extends MainWindow {
  public StudentWindow() {
    super();
    setTitle("Student Main Window");

    // add rented items
    currentUser.rentedItems = Database.getInstance().getUserRentals(currentUser.id);

    // Customize the window for student user
    customizeForStudent();
  }

  private void customizeForStudent() {
    JPanel centerPanel = (JPanel) getContentPane().getComponent(1);
    centerPanel.setLayout(new BorderLayout());
    
    JLabel rentedBooksLabel =
        new JLabel(currentUser.rentedItems.isEmpty() ? "No Books Rented" : "Rented Books");
    rentedBooksLabel.setFont(new Font(rentedBooksLabel.getFont().getFontName(), Font.BOLD, 18));
    centerPanel.add(rentedBooksLabel, BorderLayout.NORTH);

    // rented books panel
    JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    // Create a border and padding for the rented books section
    Border border =
        BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY);
    Border padding = BorderFactory.createEmptyBorder(2, 2, 2, 2);
    Border compound = BorderFactory.createCompoundBorder(border, padding);
    leftPanel.setBorder(compound);

    if (currentUser.rentedItems.isEmpty()) return;

    JPanel cardPanel = new JPanel();
    for (Item book : currentUser.rentedItems) {
      JPanel bookPanel = new RentedBookCard(book);
      cardPanel.add(bookPanel);
    }
    cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
    leftPanel.add(cardPanel);
    centerPanel.add(leftPanel, BorderLayout.WEST);
  }
}
