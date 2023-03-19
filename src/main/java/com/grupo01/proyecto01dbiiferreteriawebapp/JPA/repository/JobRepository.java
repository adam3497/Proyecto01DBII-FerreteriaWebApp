package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.repository;

import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.JobEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This interface is for the queries related to job table
 */
public interface JobRepository extends CrudRepository<JobEntity, Long> {
    JobEntity findById(long id);
    List<JobEntity> findByName(String name);
}
