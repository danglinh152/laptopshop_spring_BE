package com.twohdcd.Laptopshop.repository;

import com.twohdcd.Laptopshop.domain.Cart;
import com.twohdcd.Laptopshop.domain.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>, JpaSpecificationExecutor<Cart> {
    public List<Cart> findAll();

    public Cart findById(int id);

    public Cart save(Cart cart);
}
