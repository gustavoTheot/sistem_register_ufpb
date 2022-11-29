package org.sistem;

import org.ProductAlreadyExistsException;
import org.SistemProductInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SistemProduct implements SistemProductInterface {
    private Map<String, Product> products;

    public SistemProduct() {
        this.products = new HashMap<>();
    }

    public Collection<Product> getProducts() {
        return this.products.values();
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }

    public boolean register(String code, String name, float unitValue, String type, String expirationDate) throws ProductAlreadyExistsException {
        Product product = this.products.get(code);

        if(product == null){
            Product newProduct = new Product(code, name, unitValue, type, expirationDate);
            this.products.put(code, newProduct);
            return true;
        }

        return false;
    }

    public Product searchCode(String code) throws ProductAlreadyExistsException{
        Product productCode = this.products.get(code);

        if(productCode != null){
            return productCode;
        }

        throw new ProductAlreadyExistsException("Product does not exist");
    }

    public ArrayList<Product> searchType(String type){
        ArrayList<Product> typeProducts = new ArrayList<>();

        for(Product p : this.products.values()){
            if(p.getType().equals(type)){
                typeProducts.add(p);
            }
        }
        return typeProducts;
    }

    public ArrayList<Product> allProducts(){
        ArrayList<Product> allProducts = new ArrayList<>();
        for(Product p : this.products.values()){
            allProducts.add(p);
        }

        return allProducts;
    }

    public boolean removeProduct(String code){
        if(this.products.containsKey(code)){
            this.products.remove(code);
            return true;
        }else{
            return false;
        }
    }

}
