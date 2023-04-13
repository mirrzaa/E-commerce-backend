package com.example.eccomerbackend.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Payment")
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

    @OneToOne(mappedBy = "payment")
    private Order order;
    @OneToOne(mappedBy = "payment")
    private Request_log request_log;

    public Payment(Long id, Long user_id, String payment_method, Short card_number, Date expired_date, Byte cvv, Date created_date){
        this.id = id;
        this.user_id = user_id;
        this.payment_method = payment_method;
        this.card_number = card_number;
        this.expired_date = expired_date;
        this.cvv = cvv;
        this.created_date = created_date;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getUserId(){
        return user_id;
    }

    public void setUserId(Long userId){
        this.user_id = userId;
    }

    public String getPaymentMethod(){
        return payment_method;
    }

    public void setPaymentMethod(String payment_method){
        this.payment_method = payment_method;
    }

    public Short getCardNumber(){
        return card_number;
    }

    public void setCardNumber(Short card_number){
        this.card_number = card_number;
    }

    public Date getExpiredDate(){
        return expired_date;
    }

    public void setExpiredDate(Date expired_date){
        this.expired_date = expired_date;
    }

    public Byte getCvv(){
        return cvv;
    }

    public void setCvv(Byte cvv){
        this.cvv = cvv;
    }

    public Date getCreatedDate(){
        return created_date;
    }

    public void setCreatedDate(Date created_date){
        this.created_date = created_date;
    }
}
