package org.controller;

import org.saveData.WriteData;
import org.sistem.SistemProduct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProductSaveController implements ActionListener {
    private SistemProduct sistemPeople;
    private WriteData writeData;
    private JFrame firstWindow;

    public ProductSaveController(SistemProduct sistemPeople,JFrame firstWindow, WriteData writeData) {
        this.sistemPeople = sistemPeople;
        this.firstWindow = firstWindow;
        this.writeData = writeData;
    }

    public void actionPerformed(ActionEvent e){
        try{
            writeData.saveProduct(sistemPeople.getProducts());
            JOptionPane.showMessageDialog(firstWindow, "Product saved successfully");
        }catch (IOException ioException){
            JOptionPane.showMessageDialog(firstWindow, "Product not found" + ioException.getMessage());

        }
    }
}
