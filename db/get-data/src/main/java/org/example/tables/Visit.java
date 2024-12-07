package org.example.tables;

import java.sql.Date;

public class Visit {
    private int id;
    private Date date;
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
