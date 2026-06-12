package com.wipro.doconnectuserservice.service;

import java.util.List;

import com.wipro.doconnectuserservice.dto.UserDto;

public interface UserService {

    UserDto addUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto userDto);

    String deleteUser(Long userId);

}