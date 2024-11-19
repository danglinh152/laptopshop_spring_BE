package com.twohdcd.Laptopshop.repository;

import com.twohdcd.Laptopshop.domain.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CartDetailRepository extends JpaRepository<CartDetail, Integer>, JpaSpecificationExecutor<CartDetail> {
    public List<CartDetail> findAll();

    public CartDetail findById(int id);

    public CartDetail save(CartDetail cartDetail);
}
