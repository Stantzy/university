package org.example.tables;

public class Service {
    private int id;
    private String service;
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
