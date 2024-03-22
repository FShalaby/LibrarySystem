package ui;

import java.awt.*;
import javax.swing.*;
import sandbox.*;

public class FacultyWindow extends MainWindow {
  private final Faculty currentUser = (Faculty) CurrentUser.getUserInstance();

  public FacultyWindow() {
    super();
    setTitle("Faculty Main Window");
    this.searchWindow.dispose();
    this.searchWindow = new SearchWindow(this);

    if (currentUser == null) return;

    Database db = Database.getInstance();
    currentUser.setCourses(db.getFacultyCourses(currentUser.id));

    // Customize the window for faculty user
    customizeForFaculty();

    StringBuilder builder = new StringBuilder();
    for (Course c : currentUser.getCourses()) {
      Textbook latest = LibrarySystem.getLatestTextbook(c);
      if (latest.edition > c.getTextbook().edition) {
        builder
            .append("Newer edition of ")
            .append(c.getTextbook().name)
            .append(" exists for ")
            .append(c.getName())
            .append(". Please check with the library for more details.\n");
      }
    }

    if (!builder.toString().isEmpty()) {
      JOptionPane.showMessageDialog(this, builder);
    }
  }

  private void customizeForFaculty() {
    JPanel centerPanel = (JPanel) getContentPane().getComponent(1);

    if (currentUser == null) {
      return;
    }

    JTable table = new JTable(new CourseTableModel(currentUser.getCourses()));
    table.setFillsViewportHeight(true);
    table.setPreferredScrollableViewportSize(
        new Dimension((WIN_WIDTH / 2), WIN_HEIGHT - 160)); // padding_x: 18px

    JScrollPane scrollPane = new JScrollPane(table);

    // add panel
    centerPanel.add(scrollPane, BorderLayout.EAST);
  }
}
