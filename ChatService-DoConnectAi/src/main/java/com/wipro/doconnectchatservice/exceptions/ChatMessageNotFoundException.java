package com.wipro.doconnectchatservice.exceptions;

public class ChatMessageNotFoundException extends RuntimeException{
	
	public ChatMessageNotFoundException(String message) {
		super(message);
	}
}
