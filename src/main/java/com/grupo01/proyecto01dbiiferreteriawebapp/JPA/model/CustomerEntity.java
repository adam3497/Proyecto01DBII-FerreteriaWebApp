package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model;
import jakarta.persistence.*;
import java.io.Serializable;

/**
 * CustomerEntity is a model type of class intended to be populated by the data recovered from the
 * cliente table
 */
@Entity
@Table(name = "cliente")
public class CustomerEntity implements Serializable {
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "cedula_cliente")
    private long cedula;
    @Column(name = "nombre_cliente")
    private String name;
    @Column(name = "apellidos_cliente")
    private String lastName;
    @Column(name = "numero_telefono")
    private long phoneNumber;
    @Column(name = "direccion")
    private String address;
    @Column(name = "correo_electronico")
    private String email;

    protected CustomerEntity() {
        //no-args constructor required by JPA spec
        //this one is protected since it should not be used directly
    }

    //parametrized type of construct which can be used directly
    public CustomerEntity(long cedula, String name,
                          String lastName, long phoneNumber,
                          String address, String email) {
        this.cedula = cedula;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, cedula=%d, name='%s', " +
                        "lastName='%s', phoneNumber=%d, address='%s', email='%s'],",
                id, cedula, name, lastName, phoneNumber, address, email);
    }

    //getters and setter for each attribute on this entity
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
