package ui;

import sandbox.Item;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ItemTableModel extends AbstractTableModel {
    protected final static String[] headers = new String[]{"Name", "Location", "Type", "Price", "Category"};
    private final List<Item> items;

    public ItemTableModel(List<Item> items) {
        this.items = items;
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
        return switch (columnIndex) {
            case 0 -> items.get(0).name.getClass();
            case 1 -> items.get(0).location.getClass();
            case 2 -> items.get(0).type.getClass();
            case 3 -> items.get(0).price.getClass();
            case 4 -> items.get(0).category.getClass();
            default -> Object.class;
        };
    }

    /**
     * Returns the number of rows in the model. A
     * <code>JTable</code> uses this method to determine how many rows it
     * should display.  This method should be quick, as it
     * is called frequently during rendering.
     *
     * @return the number of rows in the model
     * @see #getColumnCount
     */
    @Override
    public int getRowCount() {
        return items.size();
    }

    /**
     * Returns the number of columns in the model. A
     * <code>JTable</code> uses this method to determine how many columns it
     * should create and display by default.
     *
     * @return the number of columns in the model
     * @see #getRowCount
     */
    @Override
    public int getColumnCount() {
        return headers.length;
    }

    /**
     * Returns the value for the cell at <code>columnIndex</code> and
     * <code>rowIndex</code>.
     *
     * @param rowIndex    the row whose value is to be queried
     * @param columnIndex the column whose value is to be queried
     * @return the value Object at the specified cell
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> items.get(rowIndex).name;
            case 1 -> items.get(rowIndex).location;
            case 2 -> items.get(rowIndex).type;
            case 3 -> items.get(rowIndex).price;
            case 4 -> items.get(rowIndex).category;
            default -> null;
        };
    }


}
