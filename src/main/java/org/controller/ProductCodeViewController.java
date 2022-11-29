package org.controller;

import org.ProductAlreadyExistsException;
import org.sistem.Product;
import org.sistem.SistemProduct;
import org.swing.ProductTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductCodeViewController implements ActionListener {
    private SistemProduct sistemProduct;
    private JFrame firstWindow;
    private JFrame secondWindow;


    public ProductCodeViewController(SistemProduct sistemProduct, JFrame firstWindow, JFrame secondWindow) {
        this.sistemProduct = sistemProduct;
        this.firstWindow = firstWindow;
        this.secondWindow = secondWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String code = JOptionPane.showInputDialog(firstWindow, "What's code is for search?");
        try {
            JOptionPane.showMessageDialog(secondWindow, sistemProduct.searchCode(code));
        } catch (ProductAlreadyExistsException ex) {
            JOptionPane.showMessageDialog(firstWindow, "Error");
            throw new RuntimeException(ex);
        }


    }
}
