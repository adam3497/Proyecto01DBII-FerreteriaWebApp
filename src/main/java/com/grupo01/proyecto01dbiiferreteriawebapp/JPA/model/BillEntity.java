package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model;

import jakarta.persistence.*;

import java.util.Date;

/**
 * BillEntity is a model type of class intended to be populated by the data recovered from the
 *  * factura table
 */
@Entity
@Table(name = "factura")
public class BillEntity {

    @Id
    @Column(name = "id_factura")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "id_cliente")
    private long customerID;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date billDate;

    @Column(name = "id_empleado")
    private long employeeID;

    public BillEntity() {}

    public BillEntity(long customerID, Date billDate, long employeeID) {
        this.customerID = customerID;
        this.billDate = billDate;
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return String.format("Bill[id=%d, customerID=%d, billDate='%s', employeeID=%d]",
                id, customerID, billDate, employeeID);
    }

    //setters and getters for the entity
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }
}
