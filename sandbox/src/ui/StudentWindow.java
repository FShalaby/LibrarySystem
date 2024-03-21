package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import sandbox.*;

public class StudentWindow extends MainWindow {
  private final Student currentUser = (Student) CurrentUser.getUserInstance();

  public StudentWindow() {
    super();
    setTitle("Student Main Window");
    this.searchWindow.dispose();
    this.searchWindow = new SearchWindow(this);

    if (currentUser != null) {
      Database db = Database.getInstance();
      currentUser.setCourses(db.getStudentCourses(currentUser.id));
      for (Course course : currentUser.getCourses()) {
        // ignore past courses
        if (course.getEndDate().isBefore(LocalDate.now())) {
          continue;
        }

        boolean hasRented = false;
        for (RentedItem rental : currentUser.getRentedItems()) {
          if (rental.getItem().id.equalsIgnoreCase(course.getTextbook().id)) {
            hasRented = true;
            break;
          }
        }

        if (!hasRented) {
          db.insertRental(course.getTextbook().id, currentUser.id, course.getEndDate());
          currentUser.addRentedItem(
              new RentedItem(course.getTextbook(), currentUser.id, course.getEndDate()));
        }
      }
    }

    // Customize the window for student user
    customizeForStudent();
  }

  private void customizeForStudent() {
    JPanel centerPanel = (JPanel) getContentPane().getComponent(1);
    addTextbookPanel(centerPanel);

    JButton newslettersButton = new JButton("Newsletters");
    newslettersButton.addActionListener(
        e -> {
          // Open the Newsletters window
          NewslettersWindow newslettersWindow = new NewslettersWindow(StudentWindow.this);
          newslettersWindow.setVisible(true);
        });

    // Add the button to the main window
    centerPanel.add(newslettersButton, BorderLayout.SOUTH);
  }

  private void addTextbookPanel(JPanel centerPanel) {
    JPanel textbookPanel = new JPanel();
    textbookPanel.setLayout(new BorderLayout());

    JLabel textbookLabel =
        new JLabel(currentUser.getRentedItems().isEmpty() ? "No Textbooks" : "Textbooks");
    textbookLabel.setFont(new Font(textbookLabel.getFont().getFontName(), Font.BOLD, 18));
    textbookPanel.add(textbookLabel, BorderLayout.NORTH);

    // textbooks panel
    JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    // Create a border and padding for the rented books section
    Border border =
        BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.LIGHT_GRAY);
    Border padding = BorderFactory.createEmptyBorder(2, 2, 2, 2);
    Border compound = BorderFactory.createCompoundBorder(border, padding);
    leftPanel.setBorder(compound);

    if (currentUser.getRentedItems().isEmpty()) return;

    JPanel cardPanel = new JPanel();
    for (RentedItem book : currentUser.getRentedItems()) {
      if (book.getItem().location.equalsIgnoreCase("online")) {
        JPanel bookPanel = new RentedBookCard(book);
        cardPanel.add(bookPanel);
      }
    }
    cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
    leftPanel.add(cardPanel);
    textbookPanel.add(leftPanel, BorderLayout.CENTER);
    centerPanel.add(textbookPanel, BorderLayout.EAST);
  }
}
