package com.example.eccomerbackend.services.impl;

import com.example.eccomerbackend.models.entities.User;
import com.example.eccomerbackend.repositories.UserRepository;
import com.example.eccomerbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return null;
        }
        existingUser.setLastName(user.getLastName());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setUsername(user.getUsername());
        existingUser.setBirthDate(user.getBirthDate());
        existingUser.setEmail(user.getEmail());
        existingUser.setUserStatus(user.getUserStatus());
        existingUser.setId(user.getId());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setPostAddress(user.getPostAddress());
        existingUser.setRoles(user.getRoles());

        return userRepository.save(existingUser);
    }


    @Override
    public void addUser(User user) {

    }  // TODO: impli interfaces UserService

    }
}
