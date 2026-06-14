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

public class AnswerEntity {
	private int id;
	
	private String title;
	private String answerText;
	private LocalDateTime createdAt;
	private boolean isAiGenerated;
	
}
