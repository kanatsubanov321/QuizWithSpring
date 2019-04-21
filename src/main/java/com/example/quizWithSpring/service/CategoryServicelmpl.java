package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.Category;
import com.example.quizWithSpring.repository.CategoryRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServicelmpl implements CategoryService {
    @Autowired
    private CategoryRep categoryRep;

    @Override
    public List<Category> findAllCategories() {
        return categoryRep.findAll();
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRep.findById(id).get();
    }

    @Override
    public Category saveCategory(Category c) {
        return categoryRep.save(c);
    }

    @Override
    public Category updateCategory(Category c) {
        return categoryRep.save(c);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRep.deleteById(id);
    }

    @Override
    public void deleteAllCategories() {
        categoryRep.deleteAll();
    }
}
