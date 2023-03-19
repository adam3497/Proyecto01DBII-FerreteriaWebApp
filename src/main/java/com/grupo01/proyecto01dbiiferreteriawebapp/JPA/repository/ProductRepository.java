package com.grupo01.proyecto01dbiiferreteriawebapp.JPA.repository;

import com.grupo01.proyecto01dbiiferreteriawebapp.JPA.model.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * This interface is for the queries related to product table
 */
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findByName(String name);
    List<ProductEntity> findByPrice(long price);
    ProductEntity findById(long id);
    List<ProductEntity> findByPriceLessThanEqual(long price);
    List<ProductEntity> findByPriceGreaterThanEqual(long price);
    List<ProductEntity> findByPriceBetween(long lowerRange, long higherRange);
    List<ProductEntity> findByExpirationDateAfter(Date date);
    List<ProductEntity> findByExpirationDateBefore(Date date);
}
