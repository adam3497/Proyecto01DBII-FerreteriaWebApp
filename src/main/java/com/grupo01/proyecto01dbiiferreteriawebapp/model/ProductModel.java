package com.grupo01.proyecto01dbiiferreteriawebapp.model;

import java.io.Serializable;
import java.util.Date;

public class ProductModel implements Serializable {

    private String name, categoryName;
    private long price, amount;
    private Date expirationDate;

    public ProductModel() {}

    public ProductModel(String name, String categoryName, long price, long amount, Date expirationDate) {
        this.name = name;
        this.categoryName = categoryName;
        this.price = price;
        this.amount = amount;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
