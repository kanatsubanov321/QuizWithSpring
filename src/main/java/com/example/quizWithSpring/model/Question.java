package com.example.quizWithSpring.model;

import javax.persistence.*;

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String description;
    private Integer grade;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Question() {
    }

    public Question(String text, String description, Integer grade, Category category) {
        this.text = text;
        this.description = description;
        this.grade = grade;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDecription() {
        return description;
    }

    public void setDecription(String decription) {
        this.description = decription;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
