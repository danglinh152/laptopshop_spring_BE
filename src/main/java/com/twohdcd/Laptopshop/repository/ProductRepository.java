package com.twohdcd.Laptopshop.repository;

import com.twohdcd.Laptopshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    public List<Product> findAll();

    public Product findById(int id);
}
