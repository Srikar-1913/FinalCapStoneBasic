package com.wipro.doconnectdiscussionservice.dto;

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

public class QuestionDto {
	
	private Long questionId;
	
	private String title;
	
	private String description;
	
	private LocalDateTime createdAt;
}
