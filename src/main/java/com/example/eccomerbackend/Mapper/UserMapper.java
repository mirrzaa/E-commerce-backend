package com.example.eccomerbackend.Mapper;

import com.example.eccomerbackend.dtos.UserDto;
import com.example.eccomerbackend.models.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setPassword(user.getPassword());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setPostAddress(user.getPostAddress());
        return userDto;
    }

    public List<UserDto> mapToDtoList(List<User> users) {
        return users.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setPostAddress(userDto.getPostAddress());
        user.setBirthDate(userDto.getBirthDate());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;

    }


}
