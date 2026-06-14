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

public class UserEntity {
	
	private int id;
	
	private String name;
	private String email;
	private String password;
	private String role;
	private LocalDateTime createdAt;
}
