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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payments_seq")
    @SequenceGenerator(name = "payments_seq",
                        allocationSize=1
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    private Long userId;
    private String paymentMethod;
    @Column(
            name = "card_number",
            unique = true
    )
    private Short cardNumber;
    private Date expiredDate;
    private Byte cvv;
    private Date createdDate;

    @OneToOne(mappedBy = "payments")
    private Order orders;
    @OneToOne(mappedBy = "payments")
    private RequestLog requestLog;
}
