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

public class AnswerDto {
	
	private Long answerId;

	private String content;
	
	private LocalDateTime createdAt;
	
}
