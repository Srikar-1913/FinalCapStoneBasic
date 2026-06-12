package com.wipro.doconnectuserservice.dto;

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

public class NotificationDto {
	private Long notificationId;
	
	private String message;
	
	private String status;
	
	private LocalDateTime createdAt;
}
