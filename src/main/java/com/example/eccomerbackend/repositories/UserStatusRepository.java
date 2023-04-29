package com.example.eccomerbackend.repositories;

import com.example.eccomerbackend.models.entities.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus,Long> {
}
