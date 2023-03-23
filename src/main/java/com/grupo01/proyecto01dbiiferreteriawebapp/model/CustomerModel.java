package com.grupo01.proyecto01dbiiferreteriawebapp.model;

import java.io.Serializable;
import java.util.Objects;

public class CustomerModel extends PersonModel implements Serializable {
    private String addressOne, addressTwo, city, province;
    private int zipcode;

    public CustomerModel() {
        super();
    }

    public CustomerModel(long cedula, long phoneNumber, String name, String lastName,
                         String email, String addressOne, String addressTwo, String city,
                         String province, int zipcode) {
        super(cedula, phoneNumber, name, lastName, email);
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.province = province;
        this.zipcode = zipcode;
    }

    public String buildAddress() {
        String longAddress = getAddressOne();
        if(!Objects.equals(getAddressTwo(), "") || getAddressTwo() != null) {
            longAddress += ", " + getAddressTwo();
        }
        longAddress += ", " + getCity() + ", " + getProvince() + " (" + getZipcode() + ")";
        return longAddress;
    }
    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
