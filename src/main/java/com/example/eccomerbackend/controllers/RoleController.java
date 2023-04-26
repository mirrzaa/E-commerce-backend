package com.example.eccomerbackend.controllers;

import com.example.eccomerbackend.models.entities.Role;
import com.example.eccomerbackend.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/")
    public ResponseEntity<List<Role>> getAll() {
        return new ResponseEntity<>(roleRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRole(@PathVariable Long id) {
        return roleRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Role createRole (@RequestBody Role role) {
        return roleRepository.save(role);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {
        return roleRepository.findById(id)
                .map(existingRole -> {
                    existingRole.setId(role.getId());
                    existingRole.setRoleName(role.getRoleName());
                    existingRole.setUsers(role.getUsers());

                    return ResponseEntity.ok(roleRepository.save(existingRole));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
