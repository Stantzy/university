package org.example.tables;

import java.sql.Time;

public class Receipt {
    private int id;
    private Time time;
    private int idVisit;
    private int idService;
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
