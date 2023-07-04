package com.example.eccomerbackend.services;

import com.example.eccomerbackend.dtos.UserDto;
import com.example.eccomerbackend.exceptions.GeneralCustomException;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id) throws GeneralCustomException;

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);
}
