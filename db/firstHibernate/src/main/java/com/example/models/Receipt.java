package com.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "чеки")
public class Receipt implements Serializable {
    private static final long serialVersionUID = 3L;
    @Id
    @Column(name = "id_Чеки", unique = true)
    private int id;
    @Column(name = "Время")
    private Time time;
    @Column(name = "id_Визит")
    private int idVisit;
    @Column(name = "id_Услуга")
    private int idService;
    @Column(name = "id_Мастер")
    private int idMaster;

    public int getId() {
        return this.id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public Time getTime() {
        return this.time;
    }
    public void setTime(Time time) {
        this.time = time;
    }

    public int getIdVisit() {
        return this.idVisit;
    }
    public void setIdVisit(int idVisit) {
        this.idVisit = idVisit;
    }

    public int getIdService() {
        return this.idService;
    }
    public void setIdService(int idService) {
        this.idService = idService;
    }

    public int getIdMaster() {
        return this.idMaster;
    }
    public void setIdMaster(int idMaster) {
        this.idMaster = idMaster;
    }
}
