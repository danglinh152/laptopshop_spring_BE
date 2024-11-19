package com.twohdcd.Laptopshop.service;

import com.twohdcd.Laptopshop.domain.Cart;
import com.twohdcd.Laptopshop.repository.CartRepository;
import com.twohdcd.Laptopshop.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(int id) {
        return cartRepository.findById(id);
    }

    public Cart addCart(Cart Carts) {
        return cartRepository.save(Carts);
    }

    public Cart updateCart(Cart Carts) {
        return cartRepository.save(Carts);
    }

    public void deleteCartsById(int id) {
        cartRepository.deleteById(id);
    }
}
