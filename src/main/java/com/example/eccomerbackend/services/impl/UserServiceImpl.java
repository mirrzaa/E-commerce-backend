package com.example.eccomerbackend.services.impl;

import com.example.eccomerbackend.dtos.UserDto;
import com.example.eccomerbackend.exceptions.UserException;
import com.example.eccomerbackend.models.entities.User;
import com.example.eccomerbackend.payload.request.SignupRequest;
import com.example.eccomerbackend.repositories.UserRepository;
import com.example.eccomerbackend.services.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserDto> getAllUsers() throws UserException {
        try {
            List<User> users = userRepository.findAll();
            return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        }catch (Exception e){
            logger.error("Error retrieving users: " + e.getMessage());
            throw new UserException("Error retrieving users: " + e.getMessage());
        }
    }

    @Override
    public UserDto getUserById(Long id) throws  UserException {
        try {
            User user = userRepository.findById(id).orElse(null);
            if (user == null) {
                return null;
            }
            return modelMapper.map(user, UserDto.class);
        }catch (Exception e){
            logger.error("Error retrieving user by ID: " + id, e);
            throw new UserException("Error retrieving user by ID: " + id);
        }

    }

    @Override
    public UserDto createUser(@Valid SignupRequest userDto) throws UserException {
        try {
            User user = modelMapper.map(userDto, User.class);
            user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword())); // Hinzufügen dieser Zeile
            user = userRepository.save(user);
            return modelMapper.map(user, UserDto.class);
        }catch (Exception e){
            logger.error("User creation failed: " + e.getMessage());
            throw new UserException("User creation failed: " + e.getMessage());
        }
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) throws UserException { //TODO: add user role and status
        try {
            User existingUser = userRepository.findById(id).orElse(null);
            if (existingUser == null) {
                return null;
            }
            modelMapper.map(userDto, existingUser);
            existingUser = userRepository.save(existingUser);
            return modelMapper.map(existingUser, UserDto.class);
        }catch (Exception e){
            logger.error("User updating failed: " + e.getMessage());
            throw new UserException("User updating failed: " + e.getMessage());
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
