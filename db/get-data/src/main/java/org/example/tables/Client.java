package org.example.tables;

public class Client {
    private int id;
    private String firstName;
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
