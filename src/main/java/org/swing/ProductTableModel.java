package org.swing;

import org.sistem.Product;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {

    private ArrayList<Product> data;
    private String columns[] = {"Code", "Name", "UnitValue", "Type", "ExpirationDate"};
    private final int COLUMN_CODE = 0;
    private final int COLUMN_NAME = 1;
    private final int COLUMN_UNITVALUE = 2;
    private final int COLUMN_TYPE = 3;
    private final int COLUMN_EXPIRATIONDATE = 4;

    public ProductTableModel(ArrayList<Product> data) {
        this.data = new ArrayList<>(data);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case COLUMN_CODE:
                return String.class;
            case COLUMN_NAME:
                return String.class;
            case COLUMN_UNITVALUE:
                return String.class;
            case COLUMN_TYPE:
                return String.class;
            case COLUMN_EXPIRATIONDATE:
                return String.class;
            default:
                return String.class;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = data.get(rowIndex);

        switch (columnIndex){
            case COLUMN_CODE:
                return product.getCode();
            case COLUMN_NAME:
                return product.getName();
            case  COLUMN_UNITVALUE:
                return product.getUnitValue();
            case COLUMN_TYPE:
                return product.getType();
            case COLUMN_EXPIRATIONDATE:
                return product.getExpirationDate();
        }

        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Product product = data.get(rowIndex);

        switch (columnIndex) {
            case COLUMN_CODE:
                product.setCode(aValue.toString());
                break;
            case COLUMN_NAME:
                product.setName(aValue.toString());
                break;
            case COLUMN_UNITVALUE:
                product.setUnitValue(Integer.parseInt(aValue.toString()));
                break;
            case COLUMN_TYPE:
                product.setType(aValue.toString());
                break;
            case COLUMN_EXPIRATIONDATE:
                product.setExpirationDate(aValue.toString());
                break;

        }
        fireTableDataChanged();
    }
}
