package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model;

import jakarta.persistence.*;

/**
 * JobEntity is a model type of class intended to be populated by the data recovered from the
 *  * puesto table
 */
@Entity
@Table(name = "puesto")
public class JobEntity {

    @Id
    @Column(name = "id_puesto")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nombre_puesto")
    private String name;

    @Column(name = "descripcion")
    private String description;

    public JobEntity() {
    }

    public JobEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Job[id=%d, name='%s', description='%s']",
                id, name, description);
    }

    //setters and getters for the entity
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
