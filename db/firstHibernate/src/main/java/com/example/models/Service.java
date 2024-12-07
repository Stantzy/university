package com.example.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "услуги")
public class Service implements Serializable {
    private static final long serialVersionUID = 4L;
    @Id
    @Column(name = "id_Услуги", unique = true)
    private int id;
    @Column(name = "Название")
    private String service;
    @Column(name = "Цена")
    private float price;

    public int getId(){
        return this.id;
    }
    public void setId(int servId){
        this.id = servId;
    }

    public String getService(){
        return this.service;
    }
    public void setService(String serv){
        this.service = serv;
    }

    public float getPrice(){
        return this.price;
    }
    public void setPrice(float value){
        this.price = value;
    }
}
