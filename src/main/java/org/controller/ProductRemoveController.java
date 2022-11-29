package org.controller;

import org.sistem.SistemProduct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductRemoveController implements ActionListener {
    private SistemProduct sistemProduct;
    private JFrame window;

    public ProductRemoveController(SistemProduct sistemProduct, JFrame window){
        this.sistemProduct = sistemProduct;
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String code = JOptionPane.showInputDialog(window, "What is code is for remove?");

        boolean remove = sistemProduct.removeProduct(code);
        if(remove){
            JOptionPane.showMessageDialog(window, "Code succesfully remove");
        }else{
            JOptionPane.showMessageDialog(window, "Code not found");
        }
    }
}
