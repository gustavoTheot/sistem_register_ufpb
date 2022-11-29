package org.swing;

import org.sistem.Product;

import javax.swing.*;
import java.util.ArrayList;

public class ProductTable extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;

    public ProductTable(ArrayList<Product> p){
        render(p);
    }

    private void render(ArrayList<Product> p){
        ProductTableModel model = new ProductTableModel(p);

        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        this.add(scrollPane);
        this.pack();
    }
}
