package com.example.quizWithSpring.controller;

import com.example.quizWithSpring.model.Category;
import com.example.quizWithSpring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories() {
        return this.categoryService.findAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return this.categoryService.findCategoryById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category saveCategory(@RequestBody Category c) {
        return this.categoryService.saveCategory(c);
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category c) {
       return this.categoryService.updateCategory(c);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        this.categoryService.deleteCategoryById(id);
    }

    @DeleteMapping
    public void deleteAllCategories() {
        this.categoryService.deleteAllCategories();
    }
}
