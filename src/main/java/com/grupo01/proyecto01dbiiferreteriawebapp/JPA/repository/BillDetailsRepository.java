package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.repository;

import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.BillDetailsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This interface is for the queries related to bill_details table
 */
public interface BillDetailsRepository extends CrudRepository<BillDetailsEntity, Long> {
    BillDetailsEntity findById(long id);
    List<BillDetailsEntity> findByProductID(long productID);
    List<BillDetailsEntity> findByBillID(long billID);
    List<BillDetailsEntity> findByPriceGreaterThanEqual(long price);
    List<BillDetailsEntity> findByPriceLessThanEqual(long price);
}
