package com.wipro.doconnectdiscussionservice.exceptions;

public class QuestionNotFoundException
        extends RuntimeException {

    public QuestionNotFoundException(String message) {
        super(message);
    }
}
