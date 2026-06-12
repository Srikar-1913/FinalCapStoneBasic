package com.wipro.doconnectdiscussionservice.exceptions;

public class AnswerNotFoundException
        extends RuntimeException {

    public AnswerNotFoundException(String message) {
        super(message);
    }
}
