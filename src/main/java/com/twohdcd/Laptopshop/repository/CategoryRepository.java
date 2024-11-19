package com.twohdcd.Laptopshop.repository;

import com.twohdcd.Laptopshop.domain.Category;
import com.twohdcd.Laptopshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {
    public List<Category> findAll();

    public Category findById(int id);

    public Category save(Category category);
}
