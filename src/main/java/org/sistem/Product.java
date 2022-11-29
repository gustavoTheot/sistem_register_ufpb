package org.sistem;

import java.io.Serializable;

public class Product implements Serializable {
    private String code;
    private String name;
    private float unitValue;
    private String type;
    private String expirationDate;

    public Product(String code, String name, float unitValue, String type, String expirationDate) {
        this.code = code;
        this.name = name;
        this.unitValue = unitValue;
        this.type = type;
        this.expirationDate = expirationDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(float unitValue) {
        this.unitValue = unitValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "\ncode: " +this.code+ "\nnome: " +this.name+ "\nvalue:" +this.unitValue+ "\n";
    }
}
