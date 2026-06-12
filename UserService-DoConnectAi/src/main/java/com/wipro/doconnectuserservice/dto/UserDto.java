package com.wipro.doconnectuserservice.dto;

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
public class UserDto {
	
	
	private Long userId;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String role;
	
	private LocalDateTime createdAt;
}
