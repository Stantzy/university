package com.example.models;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;


@Entity
@Table(name = "визиты")
public class Visit implements Serializable{
    private static final long serialVersionUID = 5L;
    @Id
    @Column(name = "id_Визиты", unique = true)
    private int id;
    @Column(name = "Дата")
    private Date date;
    @Column(name = "id_Клиент")
    private int clientId;

    public int getId(){
        return this.id;
    }
    public void setId(int value){
        this.id = value;
    }

    public Date getDate(){
        return this.date;
    }
    public void setDate(Date dateValue){
        this.date = dateValue;
    }

    public int getClientId(){
        return this.clientId;
    }
    public void setClientId(int value1){
        this.clientId = value1;
    }
}
