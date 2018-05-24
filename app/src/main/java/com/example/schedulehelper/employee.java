package com.example.schedulehelper;

public class employee {
    String name;
    String availability;

    public employee(){}

    public employee(String name, String availability){
        this.name = name;
        this.availability = availability;
    }

    public String getName(){
        return name;
    }

    public String getAvailability(){
        return availability;
    }


}
