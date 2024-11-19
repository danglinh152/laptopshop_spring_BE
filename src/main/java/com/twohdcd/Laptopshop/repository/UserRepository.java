package com.twohdcd.Laptopshop.repository;


import com.twohdcd.Laptopshop.domain.Product;
import com.twohdcd.Laptopshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    public List<User> findAll();

    public User save(User user);

    public void deleteById(int id);

    public User findById(int id);
}
