package com.example.eccomerbackend;

import com.example.eccomerbackend.dtos.UserDto;
import com.example.eccomerbackend.models.entities.User;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EccomerBackendApplicationTests {
    @Autowired
    private ModelMapper mapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void userToMapTest() {
        
        User user = new User();
        UserDto userDto = this.mapper.map(user, UserDto.class);

        
        assertEquals(user.getId(), userDto.getId());
        assertEquals(user.getFirstName(), userDto.getFirstName());
    }

}
