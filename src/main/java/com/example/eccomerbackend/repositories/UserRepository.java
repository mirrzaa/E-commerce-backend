package com.example.eccomerbackend.repositories;

import com.example.eccomerbackend.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Component
public interface UserRepository extends JpaRepository<User, Long> {


    

    Optional<User> findById(Long id);
    //Optional<User> findByEmail(Object username);

    Optional<Object> findByEmail(Object username);
}
