package com.example.eccomerbackend.services;

import com.example.eccomerbackend.dtos.UserDto;
import com.example.eccomerbackend.models.entities.User;
import com.example.eccomerbackend.models.entities.UserStatus;
import com.example.eccomerbackend.models.entitiesEnum.Status;

import java.util.List;

public interface UserService {         //TODO: writhe methods: getAllUSers, getUserByid, createUser, updatedUser,
    // TODO: map dto to entity, map entity to dto, deleteUser


    List<UserDto> getAllUsers(User user);

    UserDto getUserById(Long id);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    public void addUser(User user);

}
