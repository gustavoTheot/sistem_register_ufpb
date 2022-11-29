package org;

import org.sistem.Product;

import java.util.ArrayList;
import java.util.Collection;

public interface SistemProductInterface {
    boolean register(String code, String name, float unitValue, String type, String expirationDate) throws ProductAlreadyExistsException;
    Product searchCode(String code) throws ProductAlreadyExistsException;
    Collection<Product> searchType(String type);
    ArrayList<Product> allProducts();
    boolean removeProduct(String code);
}
