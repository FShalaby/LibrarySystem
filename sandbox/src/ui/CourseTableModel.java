package ui;

import sandbox.Course;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CourseTableModel extends AbstractTableModel {
  protected static final String[] headers =
      new String[] {
        "Name", "Section", "Term", "Textbook", "Start Date", "End Date",
      };
  private final List<Course> courses;

  public CourseTableModel(List<Course> courses) {
    this.courses = courses;
  }

  /**
   * Returns the name for the column.
   *
   * @param column the column being queried
   * @return the name of <code>column</code>
   */
  public String getColumnName(int column) {
    return headers[column];
  }

  /**
   * Returns <code>Object.class</code> regardless of <code>columnIndex</code>.
   *
   * @param columnIndex the column being queried
   * @return the Object.class
   */
  public Class<?> getColumnClass(int columnIndex) {
    return String.class;
  }

  /**
   * Returns the number of rows in the model. A <code>JTable</code> uses this method to determine
   * how many rows it should display. This method should be quick, as it is called frequently during
   * rendering.
   *
   * @return the number of rows in the model
   * @see #getColumnCount
   */
  @Override
  public int getRowCount() {
    return courses.size();
  }

  /**
   * Returns the number of columns in the model. A <code>JTable</code> uses this method to determine
   * how many columns it should create and display by default.
   *
   * @return the number of columns in the model
   * @see #getRowCount
   */
  @Override
  public int getColumnCount() {
    return headers.length;
  }

  /**
   * Returns the value for the cell at <code>columnIndex</code> and <code>rowIndex</code>.
   *
   * @param rowIndex the row whose value is to be queried
   * @param columnIndex the column whose value is to be queried
   * @return the value Object at the specified cell
   */
  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return courses.get(rowIndex).getName();
      case 1:
        return courses.get(rowIndex).getSection();
      case 2:
        return courses.get(rowIndex).getTerm();
      case 3:
        return courses.get(rowIndex).getTextbook().name;
      case 4:
        return courses.get(rowIndex).getStartDate().toString();
      case 5:
        return courses.get(rowIndex).getEndDate().toString();
      default:
        return null;
    }
  }
}
