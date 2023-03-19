package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.repository;

import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface is for the queries related to category table
 */
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
    CategoryEntity findById(long id);
    CategoryEntity findByName(String name);
}
