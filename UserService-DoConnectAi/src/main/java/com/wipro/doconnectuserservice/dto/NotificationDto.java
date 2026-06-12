package com.wipro.doconnectuserservice.dto;

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

public class NotificationDto {
	private Long notificationId;
	
	@NotBlank(message = "Message canot be empty")
	private String message;
	
	@NotBlank(message = "Status is required")
	private String status;
	
	private LocalDateTime createdAt;
}
