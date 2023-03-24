package com.grupo01.proyecto01dbiiferreteriawebapp.model;

import java.io.Serializable;

public class CategoryModel implements Serializable {
    private String name;

    public CategoryModel() {}

    public CategoryModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
