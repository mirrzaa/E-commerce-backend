package com.example.eccomerbackend.controllers;

import com.example.eccomerbackend.models.entities.User;
import com.example.eccomerbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
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
                    return ResponseEntity.ok(userRepository.save(existingUser));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
