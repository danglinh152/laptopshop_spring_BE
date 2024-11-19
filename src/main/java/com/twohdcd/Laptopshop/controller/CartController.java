package com.twohdcd.Laptopshop.controller;

import com.twohdcd.Laptopshop.domain.Cart;
import com.twohdcd.Laptopshop.service.CartService;
import com.twohdcd.Laptopshop.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/carts")
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> carts = cartService.getAllCarts();
        if (carts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carts);
    }

    @GetMapping("/carts/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable int id) {
        Cart cart = cartService.getCartById(id);
        if (cart == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cart);
    }


    @PostMapping("/carts")
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.addCart(cart));
    }

//    @PutMapping("/carts/{id}")
//    public ResponseEntity<Cart> updateCartById(@RequestBody Cart cartParam, @PathVariable int id) {
//        Cart cart = cartService.getCartById(id);
//
//        return ResponseEntity.ok(cartService.updateCart(cart));
//    }

    @DeleteMapping("/carts/{id}")
    public ResponseEntity<String> deleteCartById(@PathVariable int id) {
        cartService.deleteCartsById(id);
        return ResponseEntity.ok("Cart deleted successfully");
    }
}
