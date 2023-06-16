package com.example.eccomerbackend.services.impl;

import com.example.eccomerbackend.Mapper.UserMapper;
import com.example.eccomerbackend.dtos.UserDto;
import com.example.eccomerbackend.models.entities.User;
import com.example.eccomerbackend.models.entities.UserStatus;
import com.example.eccomerbackend.models.entitiesEnum.Status;
import com.example.eccomerbackend.repositories.UserRepository;
import com.example.eccomerbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper;

    @Override
    public List<UserDto> getAllUsers(User user) {
        List<User> users = userRepository.findAll();
        return userMapper.mapToDtoList(users);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        return userMapper.mapToDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.mapToEntity(userDto);
        user = userRepository.save(user);
        return userMapper.mapToDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return null;
        }
        existingUser.setLastName(userDto.getLastName());
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setUsername(userDto.getUsername());
        existingUser.setBirthDate(userDto.getBirthDate());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setId(userDto.getId());
        existingUser.setPassword(userDto.getPassword());
        existingUser.setPhoneNumber(userDto.getPhoneNumber());
        existingUser.setPostAddress(userDto.getPostAddress());

        return userMapper.mapToDto(existingUser);
    }


    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }


}
