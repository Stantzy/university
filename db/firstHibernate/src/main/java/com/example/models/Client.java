package com.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "клиенты")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_Клиенты", unique = true)
    private int id;
    @Column(name = "Имя")
    private String firstName;
    @Column(name = "Фамилия")
    private String lastName;

    public int getId(){
        return this.id;
    }
    public void setId(int value){
        this.id = value;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String fName){
        this.firstName = fName;
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lName){
        this.lastName = lName;
    }

}