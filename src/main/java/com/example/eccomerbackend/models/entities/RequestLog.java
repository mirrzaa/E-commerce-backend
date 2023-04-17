package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;
@Data
@Entity
@RequiredArgsConstructor
//@NoArgsConstructor
@Table(name = "requestLogs")
public class RequestLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date created_date;

    @OneToOne()
    @JoinColumn(name = "payment_id")
    private Payment payments;
}
