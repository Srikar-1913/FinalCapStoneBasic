package com.wipro.doconnect.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class ModerationLogEntity {
	
	private int id;
	private String content;
	private String reason;
	private LocalDateTime createdAt;
}
