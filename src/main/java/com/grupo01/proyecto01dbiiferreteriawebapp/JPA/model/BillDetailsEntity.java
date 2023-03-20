package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model;

import jakarta.persistence.*;

/**
 * BillDetailsEntity is a model type of class intended to be populated by the data recovered from the
 *  * detalle table
 */
@Entity
@Table(name = "detalle")
public class BillDetailsEntity {

    @Id
    @Column(name = "id_detalle", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "precio", nullable = false)
    private long price;

    @Column(name = "cantidad", nullable = false)
    private long amount;

    @Column(name = "id_producto", nullable = false)
    private long productID;

    @Column(name = "id_factura", nullable = false)
    private long billID;

    public BillDetailsEntity() {}

    public BillDetailsEntity(long price, long amount, long productID, long billID) {
        this.price = price;
        this.amount = amount;
        this.productID = productID;
        this.billID = billID;
    }

    @Override
    public String toString() {
        return String.format("Bill Details[id=%d, price=%d, amount=%d, productID=%d, billID=%d]",
                id, price, amount, productID, billID);
    }

    //setters and getters for the entity
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public long getBillID() {
        return billID;
    }

    public void setBillID(long billID) {
        this.billID = billID;
    }
}
