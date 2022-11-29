package org;

import org.swing.SistemProductGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame windows = new SistemProductGUI();
        windows.setVisible(true);
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
