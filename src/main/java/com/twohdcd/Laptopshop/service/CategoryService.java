package com.twohdcd.Laptopshop.service;


import com.twohdcd.Laptopshop.domain.Category;
import com.twohdcd.Laptopshop.domain.Product;
import com.twohdcd.Laptopshop.repository.CategoryRepository;
import com.twohdcd.Laptopshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    public Category addCategory(Category Category) {
        return categoryRepository.save(Category);
    }

    public Category updateCategory(Category Category) {
        return categoryRepository.save(Category);
    }

    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }
}
