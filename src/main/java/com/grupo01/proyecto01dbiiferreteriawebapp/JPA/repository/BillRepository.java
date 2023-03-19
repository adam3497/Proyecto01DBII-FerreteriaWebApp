package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.repository;

import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.BillEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * This interface is for the queries related to bill table
 */
public interface BillRepository extends CrudRepository<BillEntity, Long> {
    BillEntity findById(long id);
    List<BillEntity> findByCustomerID(long id);
    List<BillEntity> findByBillDate(Date billDate);
    List<BillEntity> findByEmployeeID(long employeeID);
}
