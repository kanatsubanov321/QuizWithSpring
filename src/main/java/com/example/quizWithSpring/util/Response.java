package com.example.quizWithSpring.util;

public class Response {
    private boolean success;
    private String message;
    private Object quiz;

    public Response() {

    }

    public Response(boolean success, String message, Object quiz) {
        this.success = success;
        this.message = message;
        this.quiz = quiz;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getQuiz() {
        return quiz;
    }

    public void setQuiz(Object quiz) {
        this.quiz = quiz;
    }
}
