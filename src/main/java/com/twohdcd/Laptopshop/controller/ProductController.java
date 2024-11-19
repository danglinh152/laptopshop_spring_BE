package com.twohdcd.Laptopshop.controller;


import com.twohdcd.Laptopshop.domain.Product;
import com.twohdcd.Laptopshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getAllProducts();

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProductById(@RequestBody Product productParam, @PathVariable int id) {
        Product product = productService.getProductById(id);
        product.setProductName(productParam.getProductName());
        product.setProductDesc(productParam.getProductDesc());
        product.setProductPrice(productParam.getProductPrice());
        product.setProductStock(productParam.getProductStock());
        product.setProductImage(productParam.getProductImage());
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
