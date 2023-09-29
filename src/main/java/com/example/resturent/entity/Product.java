package com.example.resturent.entity;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Product {
    @Id
    @GeneratedValue
    private int oid;
    private int id;
    private String quantity;
    private String size;
    private String name;
    private int price;
    @Column(name = "date" )
    private Date Date;

    @PrePersist
    public void prePersist(){
        java.util.Date currentDate = new java.util.Date();
                Date = new Date(currentDate.getTime());
    }
}
