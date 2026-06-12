package com.wipro.doconnectchatservice.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
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

public class ChatMessageDto {
	
	private Long messageId;
	
	@NotBlank(message = "Message cannot be empty")
	private String message;
	
	private LocalDateTime sentAt;
	
}
