package com.wipro.doconnectdiscussionservice.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
	
	@NotBlank(message = "Title is required")
	private String title;
	
	@NotBlank(message = "Description is required")
	@Size(min = 10, message = "Description must contain minium 10 characters")
	private String description;
	
	private LocalDateTime createdAt;
}
