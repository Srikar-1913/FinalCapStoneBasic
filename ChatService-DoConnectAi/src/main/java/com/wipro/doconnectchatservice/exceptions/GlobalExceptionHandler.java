package com.wipro.doconnectchatservice.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
	
	@ExceptionHandler(
            ChatMessageNotFoundException.class)
    public Map<String, Object>
    handleChatMessageNotFoundException(
            ChatMessageNotFoundException ex) {

        Map<String, Object> response =
                new HashMap<>();

        response.put("timestamp",
                LocalDateTime.now());

        response.put("status",
                HttpStatus.NOT_FOUND.value());

        response.put("message",
                ex.getMessage());

        return response;
    }

}
