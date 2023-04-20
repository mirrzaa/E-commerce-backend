package com.example.eccomerbackend.models.entities;

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
    private String basic;
    private String premium;
    private String gold;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
