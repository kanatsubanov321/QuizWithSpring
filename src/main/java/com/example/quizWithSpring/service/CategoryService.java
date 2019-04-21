package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findCategoryById(Long id);
    Category saveCategory(Category c);
    Category updateCategory(Category c);
    void deleteCategoryById(Long id);
    void deleteAllCategories();
}
