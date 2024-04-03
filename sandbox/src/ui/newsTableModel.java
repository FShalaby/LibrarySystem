package ui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sandbox.Item;
import sandbox.ItemPermission;
import sandbox.Newsletter;

public class newsTableModel extends AbstractTableModel {
    protected static final String[] headers =
            new String[] {
                    "Id", "Name", "Url", "Fee",
            };
    private final List<Newsletter> news;

    public newsTableModel(List<Newsletter> news) {
        this.news = news;
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
        switch (columnIndex) {
            case 0:
                return news.get(0).id.getClass();
            case 1:
                return news.get(0).name.getClass();
            case 2:
                return news.get(0).url.getClass();
            case 3:
                return String.class;
            default:
                return Object.class;
        }
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
        return news.size();
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
                return news.get(rowIndex).id;
            case 1:
                return news.get(rowIndex).name;
            case 2:
                return news.get(rowIndex).url;
            case 3:
                return "$" + news.get(rowIndex).fee;
            default:
                return null;
        }
    }
}
