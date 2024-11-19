package com.twohdcd.Laptopshop.repository;

import com.twohdcd.Laptopshop.domain.Category;
import com.twohdcd.Laptopshop.domain.Delivery;
import com.twohdcd.Laptopshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer>, JpaSpecificationExecutor<Delivery> {
    public List<Delivery> findAll();

    public Delivery findById(int id);

    public Delivery save(Delivery delivery);
}
