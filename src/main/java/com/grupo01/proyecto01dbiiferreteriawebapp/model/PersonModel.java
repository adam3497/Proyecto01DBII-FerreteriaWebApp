package com.grupo01.proyecto01dbiiferreteriawebapp.model;

public class PersonModel {
    private long cedula, phoneNumber;
    private String name, lastName, email;

    public PersonModel () {}

    public PersonModel(long cedula, long phoneNumber, String name, String lastName, String email) {
        this.cedula = cedula;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
