package com.example.eccomerbackend.services;

import com.example.eccomerbackend.models.entities.User;
import com.example.eccomerbackend.models.entities.UserStatus;
import com.example.eccomerbackend.models.entitiesEnum.Status;

import java.util.List;

public interface UserService {         //TODO: writhe methods: getAllUSers, getUserByid, createUser, updatedUser,
    // map dto to entity, map entity to dto, deleteUser
    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    public abstract void addUser(User user);
    Status getUserStatus(UserStatus userStatus);
}
