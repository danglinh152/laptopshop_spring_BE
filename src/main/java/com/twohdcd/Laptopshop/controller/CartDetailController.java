package com.twohdcd.Laptopshop.controller;

import com.twohdcd.Laptopshop.domain.CartDetail;
import com.twohdcd.Laptopshop.service.CartDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartDetailController {
    private CartDetailService cartDetailService;

    public CartDetailController(CartDetailService cartDetailService) {
        this.cartDetailService = cartDetailService;
    }

    @GetMapping("/cart-details")
    public ResponseEntity<List<CartDetail>> getAllCartDetails() {
        List<CartDetail> cartDetails = cartDetailService.getAllCartDetails();
        if (cartDetails.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cartDetails);
    }

    @GetMapping("/cart-details/{id}")
    public ResponseEntity<CartDetail> getCartDetailById(@PathVariable int id) {
        CartDetail cartDetail = cartDetailService.getCartDetailById(id);
        if (cartDetail == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cartDetail);
    }


    @PostMapping("/cart-details")
    public ResponseEntity<CartDetail> addCartDetail(@RequestBody CartDetail cartDetail) {
        return ResponseEntity.ok(cartDetailService.addCartDetail(cartDetail));
    }

    @PutMapping("/cart-details/{id}")
    public ResponseEntity<CartDetail> updateCartDetailById(@RequestBody CartDetail cartDetailParam, @PathVariable int id) {
        CartDetail cartDetail = cartDetailService.getCartDetailById(id);
        cartDetail.setQuantity(cartDetailParam.getQuantity());
        return ResponseEntity.ok(cartDetailService.updateCartDetail(cartDetail));
    }

    @DeleteMapping("/cart-details/{id}")
    public ResponseEntity<String> deleteCartDetailsById(@PathVariable int id) {
        cartDetailService.deleteCartDetailById(id);
        return ResponseEntity.ok("CartDetail deleted successfully");
    }
}
