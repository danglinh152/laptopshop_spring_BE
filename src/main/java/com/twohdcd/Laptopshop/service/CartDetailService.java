package com.twohdcd.Laptopshop.service;


import com.twohdcd.Laptopshop.domain.CartDetail;
import com.twohdcd.Laptopshop.repository.CartDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailService {

    private final CartDetailRepository cartDetailRepository;

    public CartDetailService(CartDetailRepository cartDetailRepository) {
        this.cartDetailRepository = cartDetailRepository;
    }

    public List<CartDetail> getAllCartDetails() {
        return cartDetailRepository.findAll();
    }

    public CartDetail getCartDetailById(int id) {
        return cartDetailRepository.findById(id);
    }

    public CartDetail addCartDetail(CartDetail CartDetails) {
        return cartDetailRepository.save(CartDetails);
    }

    public CartDetail updateCartDetail(CartDetail CartDetails) {
        return cartDetailRepository.save(CartDetails);
    }

    public void deleteCartDetailById(int id) {
        cartDetailRepository.deleteById(id);
    }
}
