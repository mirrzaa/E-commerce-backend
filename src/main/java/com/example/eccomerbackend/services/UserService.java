package com.example.eccomerbackend.services;

import com.example.eccomerbackend.dtos.UserDto;
import com.example.eccomerbackend.exceptions.UserException;
import com.example.eccomerbackend.payload.request.SignupRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers() throws UserException;

    UserDto getUserById(Long id) throws  UserException;

    UserDto createUser(@Valid SignupRequest userDto) throws UserException;

    UserDto updateUser(Long id, UserDto userDto) throws UserException;

    void deleteUser(Long id);

}
