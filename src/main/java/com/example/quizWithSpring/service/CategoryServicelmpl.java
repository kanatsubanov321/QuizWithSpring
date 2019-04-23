package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.Category;
import com.example.quizWithSpring.model.Question;
import com.example.quizWithSpring.repository.CategoryRep;
import com.example.quizWithSpring.repository.QuestionRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServicelmpl implements CategoryService {
    @Autowired
    private CategoryRep categoryRep;
    @Autowired
    private QuestionService questionService;

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

    @Override
    public List<Question> getQuestionsByCategory(Long id) {
        List<Question> questions = questionService.findAllQuestions();
        ArrayList<Question> questions1 = new ArrayList<>();
        for (Question question : questions) {
            if (question.getId().equals(id)) {
                questions1.add(question);
            }
        }
        return questions1;
    }
}
