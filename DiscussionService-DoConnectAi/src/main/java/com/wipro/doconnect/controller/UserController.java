package com.wipro.doconnect.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.doconnect.dto.UserDto;
import com.wipro.doconnect.entity.User;
import com.wipro.doconnect.security.JwtUtil;
import com.wipro.doconnect.service.UserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private JwtUtil jwtUtil;

	// REGISTER
	@PostMapping("/register")
	public UserDto register(@RequestBody UserDto userDto) {
		return userService.addUser(userDto);
	}

	// LOGIN → JWT TOKEN
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody UserDto dto) {

		User user = userService.login(dto.getEmail(), dto.getPassword());

		String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

		Map<String, String> response = new HashMap<>();
		response.put("token", token);

		return response;
	}

	// ADMIN ONLY
	@GetMapping("/all")
	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}

	// AUTHENTICATED USERS
	@GetMapping("/{id}")
	public UserDto getUser(@PathVariable Long id) {
		
		return userService.getUserById(id);
	}

	@PutMapping("/{id}")
	public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto dto) {
		return userService.updateUser(id, dto);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}
}