package com.example.quizWithSpring.util;

public class Response {
    private boolean success;
    private String comment;

    public Response() {

    }

    public Response(boolean success, String comment) {
        this.success = success;
        this.comment = comment;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return comment;
    }

    public void setMessage(String comment) {
        this.comment = comment;
    }
}
