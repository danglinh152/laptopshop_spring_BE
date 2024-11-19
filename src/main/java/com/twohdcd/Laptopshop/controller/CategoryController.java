package com.twohdcd.Laptopshop.controller;

import com.twohdcd.Laptopshop.domain.Category;
import com.twohdcd.Laptopshop.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(category);
    }


    @PostMapping("/categories")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.addCategory(category));
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategoryById(@RequestBody Category categoryParam, @PathVariable int id) {
        Category category = categoryService.getCategoryById(id);
        category.setCategoryName(categoryParam.getCategoryName());
        return ResponseEntity.ok(categoryService.updateCategory(category));
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok("Category deleted successfully");
    }
}
