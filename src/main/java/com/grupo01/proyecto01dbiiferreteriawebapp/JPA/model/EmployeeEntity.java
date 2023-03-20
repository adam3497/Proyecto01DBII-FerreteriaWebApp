package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * EmployeeEntity is a model type of class intended to be populated by the data recovered from the
 *  * empleado table
 */
@Entity
@Table(name = "empleado")
public class EmployeeEntity implements Serializable {

    @Id
    @Column(name = "id_empleado", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cedula_empleado", unique = true, nullable = false)
    private long cedula;

    @Column(name = "nombre_empleado", nullable = false)
    private String name;

    @Column(name = "apellidos_empleado", nullable = false)
    private String lastName;

    @Column(name = "numero_telefono", nullable = false)
    private long phoneNumber;

    @Column(name = "id_puesto", nullable = false)
    private long jobID;

    @Column(name = "correo_electronico", nullable = false, unique = true)
    private String email;

    protected EmployeeEntity() {
        //no-args constructor required by JPA spec
        //this one is protected since it should not be used directly
    }

    //parametrized type of construct which can be used directly
    public EmployeeEntity(long cedula, String name, String lastName, long phoneNumber, long jobID, String email) {
        this.cedula = cedula;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.jobID = jobID;
        this.email = email;
        //TODO: change the jobID for the job name
    }

    @Override
    public String toString() {
        return String.format("Employee[id=%d, cedula=%d, name='%s'," +
                        "lastName='%s', phoneNumber=%d, jobID=%d, email='%s']",
                id, cedula, name, lastName, phoneNumber, jobID, email);
    }

    //getters and setter for each attribute on this entity

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public long getJobID() {
        return jobID;
    }

    public void setJobID(long jobID) {
        this.jobID = jobID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
