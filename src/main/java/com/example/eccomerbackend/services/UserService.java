package com.example.eccomerbackend.services;

import com.example.eccomerbackend.dtos.UserDto;
import com.example.eccomerbackend.exceptions.GeneralCustomException;
import com.example.eccomerbackend.exceptions.UserException;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers() throws UserException;

    UserDto getUserById(Long id) throws  UserException;

    UserDto createUser(UserDto userDto) throws UserException;

    UserDto updateUser(Long id, UserDto userDto) throws UserException;

    void deleteUser(Long id);

}
