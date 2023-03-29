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

    public Order(Long id, Long userId, Date creationDate, Date updatedDate){
        this.id = id;
        this.userId = userId;
        this.creationDate = creationDate;
        this.updatedDate = updatedDate;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getUserId(){
        return userId;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

    public Date getCreationDate(){
        return creationDate;
    }

    public void setCreationDate(Date creationDate){
        this.creationDate = creationDate;
    }

    public Date getUpdatedDate(){
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDateDate){
        this.updatedDate = updatedDateDate;
    }
}
