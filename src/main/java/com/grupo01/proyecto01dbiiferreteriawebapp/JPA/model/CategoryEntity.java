package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model;

import jakarta.persistence.*;

/**
 * CategoryEntity is a model type of class intended to be populated by the data recovered from the
 *  * categoria table
 */
@Entity
@Table(name = "categoria")
public class CategoryEntity {

    @Id
    @Column(name = "id_categoria", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nombre_categoria", nullable = false)
    private String name;

    public CategoryEntity() {
        //no-args constructor required by JPA spec
        //this one is protected since it should not be used directly
    }

    public CategoryEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Category[id=%d, name='%s']", id, name);
    }

    //setters and getters for the attributes of this entity
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
}
