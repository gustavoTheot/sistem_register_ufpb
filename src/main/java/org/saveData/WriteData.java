package org.saveData;

import org.sistem.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class WriteData {

    private String file = "products.txt";

    public void saveProduct(Collection<Product> product) throws IOException {
        ObjectOutputStream save = null;
        try{
            save = new ObjectOutputStream(new FileOutputStream(file));
            ArrayList<Product> productSave = new ArrayList<>(product);
            save.writeObject(productSave);
        }finally {
            if(save != null){
                save.close();
            }
        }
    }

    public Collection<Product> loadProduct() throws IOException, ClassNotFoundException {
        ObjectInputStream load = null;

        try{
            load = new ObjectInputStream(new FileInputStream(file));
            Collection<Product> productLoad = (Collection<Product>) load.readObject();
            return productLoad;
        }finally {
            if(load != null){
                load.close();
            }
        }
    }
}

