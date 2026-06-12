package com.wipro.doconnectuserservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doconnectuserservice.dto.UserDto;
import com.wipro.doconnectuserservice.entity.User;
import com.wipro.doconnectuserservice.exceptions.UserNotFoundException;
import com.wipro.doconnectuserservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Add User
    @Override
    public UserDto addUser(UserDto userDto) {

        User user = convertToEntity(userDto);

        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        return convertToDto(savedUser);
    }

    // Get User By Id
    @Override
    public UserDto getUserById(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id : " + userId));

        return convertToDto(user);
    }

    // Get All Users
    @Override
    public List<UserDto> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Update User
    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {

        User existingUser = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id : " + userId));

        updateEntity(existingUser, userDto);

        User updatedUser = userRepository.save(existingUser);

        return convertToDto(updatedUser);
    }

    // Delete User
    @Override
    public String deleteUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id : " + userId));

        userRepository.delete(user);

        return "User deleted successfully";
    }

    // Convert DTO to Entity
    private User convertToEntity(UserDto userDto) {

        User user = new User();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        return user;
    }

    // Convert Entity to DTO
    private UserDto convertToDto(User user) {

        UserDto dto = new UserDto();

        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());

        return dto;
    }

    // Update Entity values
    private void updateEntity(User user, UserDto userDto) {

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
    }
}
