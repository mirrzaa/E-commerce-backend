package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Data
@RequiredArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long user_id;
    private String payment_method;
    private Short card_number;
    private Date expired_date;
    private Byte cvv;
    private Date created_date;

    @OneToOne(mappedBy = "payments")
    private Order orders;
    @OneToOne(mappedBy = "payments")
    private RequestLog requestLog;
}
