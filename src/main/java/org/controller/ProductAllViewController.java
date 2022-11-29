package org.controller;

import org.sistem.Product;
import org.swing.ProductTable;
import org.sistem.SistemProduct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProductAllViewController implements ActionListener {
    private SistemProduct sistemProduct;
    private JFrame window;


    public ProductAllViewController(SistemProduct sistemProduct, JFrame window) {
        this.sistemProduct = sistemProduct;
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Product> allProduct = sistemProduct.allProducts();

        System.out.println(allProduct);

        if(allProduct.size() > 0){
            ProductTable table = new ProductTable(allProduct);
            table.setLocationRelativeTo(null);
            table.setVisible(true);

        }else{
            JOptionPane.showMessageDialog(window, "No person was found");
        }
    }
}
