package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model;

import jakarta.persistence.*;

import java.util.Date;

/**
 * ProductEntity is a model type of class intended to be populated by the data recovered from the
 *  * producto table
 */
@Entity
@Table(name = "producto")
public class ProductEntity {

    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nombre_producto")
    private String name;

    @Column(name = "precio_producto")
    private long price;

    @Column(name = "vencimiento")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @Column(name = "cantidad")
    private long amount;

    @Column(name = "id_categoria")
    private long categoryID;

    public ProductEntity() {
        //no-args constructor required by JPA spec
        //this one is protected since it should not be used directly
    }

    public ProductEntity(String name, long price, Date expirationDate, long amount, long categoryID) {
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
        this.amount = amount;
        this.categoryID = categoryID;
        //TODO: change categoryID by the category name
    }

    @Override
    public String toString() {
        return String.format("Product[id=%d, name='%s', price=%d, " +
                        "expirationDate='%s', amount=%d, categoryID=%d]",
                id, name, price, expirationDate, amount, categoryID);
    }

    //setters and getters for every attribute
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }
}
