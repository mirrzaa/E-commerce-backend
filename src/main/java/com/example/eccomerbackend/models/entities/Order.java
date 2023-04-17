package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;

import lombok.*;
import java.util.Collection;
import java.util.*;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date creationDate;
    private Date updatedDate;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User users;


    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product products;

    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payments;
}
