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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requestLogs_seq")
    @SequenceGenerator(name = "requestLogs_seq",
                       allocationSize=1)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    private Date createdDate;

    @OneToOne()
    @JoinColumn(name = "payment_id")
    private Payment payments;
}
