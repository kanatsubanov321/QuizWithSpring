package com.example.quizWithSpring.repository;

import com.example.quizWithSpring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRep
        extends JpaRepository<Category, Long> {
}
