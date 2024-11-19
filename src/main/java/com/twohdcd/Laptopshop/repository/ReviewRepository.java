package com.twohdcd.Laptopshop.repository;

import com.twohdcd.Laptopshop.domain.Category;
import com.twohdcd.Laptopshop.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer>, JpaSpecificationExecutor<Review> {
    public List<Review> findAll();

    public Review findById(int id);

    public Review save(Review review);
}
