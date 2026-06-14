package com.wipro.doconnect.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class ChatMessageEntity {
	private int id;
	private String message;
	private LocalDateTime timestamp;
	
}
