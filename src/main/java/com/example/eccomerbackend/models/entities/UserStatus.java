package com.example.eccomerbackend.models.entities;

import com.example.eccomerbackend.models.entitiesEnum.Status;
import jakarta.persistence.*;
import lombok.*;

@Data
@RequiredArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "userStatus")
public class UserStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Status userStatus;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
