package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.repository;

import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This interface is for the queries related to customer table
 */
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    List<CustomerEntity> findByLastName(String lastName);
    CustomerEntity findById(long id);
}
