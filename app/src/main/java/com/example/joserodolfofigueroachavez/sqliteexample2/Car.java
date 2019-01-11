package com.example.joserodolfofigueroachavez.sqliteexample2;

public class Car {

    private int id;
    private String name;
    private String color;

    public Car(int Id, String Name, String Color){
        this.id = Id;
        this.name = Name;
        this.color = Color;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }
}
