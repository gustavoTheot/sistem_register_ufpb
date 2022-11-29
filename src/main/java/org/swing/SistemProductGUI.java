package org.swing;

import org.controller.*;
import org.sistem.Product;
import org.ProductAlreadyExistsException;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.saveData.WriteData;
import org.sistem.SistemProduct;


public class SistemProductGUI extends JFrame {

    JMenuBar menuBar = new JMenuBar();
    JFrame window = new JFrame();
    JMenu search, remove, toSave;
    JMenuItem itemSearchCode, itemSearchType, itemViewAllProducts, itemRemoveProduct, itemSave;
    JLabel labelCode, labelName, labelUnitValue, labelType, labelValueDate;
    JTextField textFieldCode, textFieldName, textFieldUnitValue, textFieldType, textFieldValueDate;
    JButton buttonConfirm;
    WriteData save = new WriteData();


    public SistemProductGUI(){
        final SistemProduct sistemProduct = new SistemProduct();
        Container container = getContentPane();
        container.setLayout(null);

        setTitle("Sistem Product");
        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);

        /* =============== Load Products ================ */

        Collection<Product> products = null;
        try{
            products = save.loadProduct();
            for(Product p : products){
                sistemProduct.register(p.getCode(), p.getName(), p.getUnitValue(), p.getType(), p.getExpirationDate());
            }
            JOptionPane.showMessageDialog(null, "Contact recoverd");
        }catch (IOException | ClassNotFoundException | ProductAlreadyExistsException e){
            JOptionPane.showMessageDialog(null, "Contact ot recoverd - " +e.getMessage());
        }

        /* =============== Menu ================ */
        setJMenuBar(menuBar);

        search = new JMenu("Search");
        menuBar.add(search);
        itemSearchCode = new JMenuItem("Search code");
        itemSearchCode.addActionListener(new ProductCodeViewController(sistemProduct, this, this));
        itemSearchType = new JMenuItem("Search type");
        itemSearchType.addActionListener(new ProductTypeViewController(sistemProduct, this));
        itemViewAllProducts = new JMenuItem("View all produtcs");
        itemViewAllProducts.addActionListener(new ProductAllViewController(sistemProduct, this));
        search.add(itemSearchCode);
        search.add(itemSearchType);
        search.add(itemViewAllProducts);

        remove = new JMenu("Remove");
        menuBar.add(remove);
        itemRemoveProduct = new JMenuItem("Remove");
        itemRemoveProduct.addActionListener(new ProductRemoveController(sistemProduct, this));
        remove.add(itemRemoveProduct);

        toSave = new JMenu("Save");
        menuBar.add(toSave);
        itemSave = new JMenuItem("To Save");
        itemSave.addActionListener(new ProductSaveController(sistemProduct, this, save));
        toSave.add(itemSave);

        File file = new File(".");
        System.out.println("==>"+file.getAbsolutePath());

        /* =============== Forms ================ */
        labelCode = new JLabel("Code: ");
        labelCode.setFont(new Font("Roboto", Font.PLAIN, 16));
        labelCode.setSize(150,30);
        labelCode.setLocation(100, 100);
        container.add(labelCode);

        textFieldCode = new JTextField();
        textFieldCode.setMargin(new Insets(0,5,0,0));
        textFieldCode.setSize(200,30);
        textFieldCode.setLocation(230, 100);
        container.add(textFieldCode);

        labelName = new JLabel("Name: ");
        labelName.setFont(new Font("Roboto", Font.PLAIN, 16));
        labelName.setSize(150,30);
        labelName.setLocation(100, 150);
        container.add(labelName);

        textFieldName = new JTextField();
        textFieldName.setMargin(new Insets(0,5,0,0));
        textFieldName.setSize(200,30);
        textFieldName.setLocation(230, 150);
        container.add(textFieldName);

        labelUnitValue = new JLabel("Value per unit: ");
        labelUnitValue.setFont(new Font("Roboto", Font.PLAIN, 16));
        labelUnitValue.setSize(150,30);
        labelUnitValue.setLocation(100, 200);
        container.add(labelUnitValue);

        textFieldUnitValue = new JTextField();
        textFieldUnitValue.setMargin(new Insets(0,5,0,0));
        textFieldUnitValue.setSize(200,30);
        textFieldUnitValue.setLocation(230, 200);
        container.add(textFieldUnitValue);

        labelType = new JLabel("Type: ");
        labelType.setFont(new Font("Roboto", Font.PLAIN, 16));
        labelType.setSize(150,30);
        labelType.setLocation(100, 250);
        container.add(labelType);

        textFieldType = new JTextField();
        textFieldType.setMargin(new Insets(0,5,0,0));
        textFieldType.setSize(200,30);
        textFieldType.setLocation(230, 250);
        container.add(textFieldType);

        labelValueDate = new JLabel("Value date: ");
        labelValueDate.setFont(new Font("Roboto", Font.PLAIN, 16));
        labelValueDate.setSize(150,30);
        labelValueDate.setLocation(100, 300);
        container.add(labelValueDate);

        textFieldValueDate = new JTextField();
        textFieldValueDate.setMargin(new Insets(0,5,0,0));
        textFieldValueDate.setSize(200,30);
        textFieldValueDate.setLocation(230, 300);
        container.add(textFieldValueDate);

        buttonConfirm = new JButton("Register");
        buttonConfirm.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonConfirm.setSize(100, 40);
        buttonConfirm.setLocation(230, 400);
        buttonConfirm.addActionListener((ae) -> {
            try {
                sistemProduct.register(textFieldCode.getText(), textFieldName.getText(), Float.parseFloat(textFieldUnitValue.getText()), textFieldType.getText(), textFieldValueDate.getText());
                JOptionPane.showMessageDialog(window, "Register product");
                textFieldCode.setText("");
                textFieldName.setText("");
                textFieldUnitValue.setText("");
                textFieldType.setText("");
                textFieldValueDate.setText("");
            } catch (ProductAlreadyExistsException e) {
                throw new RuntimeException(e);
            }
        });
        container.add(buttonConfirm);
        setVisible(true);
    }
}
