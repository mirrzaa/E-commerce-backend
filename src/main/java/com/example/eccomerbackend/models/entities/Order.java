package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Date creationDate;
    private Date updatedDate;
}
