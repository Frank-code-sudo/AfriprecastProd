package com.production.AfriprecastProd.repository;

import com.production.AfriprecastProd.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(Integer id);
    Optional<Product> findFirstById(Integer id);
}
