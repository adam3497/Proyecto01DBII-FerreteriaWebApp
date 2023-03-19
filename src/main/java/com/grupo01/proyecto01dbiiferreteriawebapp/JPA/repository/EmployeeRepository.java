package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.repository;

import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This interface is for the queries related to employee table
 */
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findByName(String name);
    EmployeeEntity findById(long id);
    List<EmployeeEntity> findByLastName(String lastName);
    EmployeeEntity findByCedula(long cedula);
    List<EmployeeEntity> findByNameAndLastName(String name, String lastName);
}
