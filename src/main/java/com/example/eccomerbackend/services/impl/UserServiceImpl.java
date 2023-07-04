package com.example.eccomerbackend.services.impl;

import com.example.eccomerbackend.dtos.UserDto;
import com.example.eccomerbackend.exceptions.GeneralCustomException;
import com.example.eccomerbackend.models.entities.User;
import com.example.eccomerbackend.repositories.UserRepository;
import com.example.eccomerbackend.services.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) throws GeneralCustomException {
        try {
            User user = userRepository.findById(id).orElse(null);
            if (user == null) {
                return null;
            }
            return modelMapper.map(user, UserDto.class);
        }catch (Exception e){
            logger.error("Error retrieving user by ID: " + id, e);
            throw new GeneralCustomException("Error retrieving user by ID: " + id);
        }

    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user;
        user = modelMapper.map(userDto, User.class);
        user = userRepository.save(user);

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return null;
        }
        modelMapper.map(userDto, existingUser);
        existingUser = userRepository.save(existingUser);
        return modelMapper.map(existingUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
