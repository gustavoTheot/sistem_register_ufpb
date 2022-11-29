package org.controller;

import org.sistem.Product;
import org.sistem.SistemProduct;
import org.swing.ProductTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProductTypeViewController implements ActionListener {
    private SistemProduct sistemProduct;
    private JFrame windows;

    public ProductTypeViewController(SistemProduct sistemProduct, JFrame windows) {
        this.sistemProduct = sistemProduct;
        this.windows = windows;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String typeProduct = JOptionPane.showInputDialog("What's type is product?");
        ArrayList<Product> productsType = sistemProduct.searchType(typeProduct);

        ProductTable table = new ProductTable(productsType);
        table.setVisible(true);
        table.setLocationRelativeTo(null);

    }
}
