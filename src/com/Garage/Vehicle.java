package com.Garage;

public class Vehicle extends CarShop {

    private String name;
    private String seats;

    public Vehicle(String name, String seats){
        this.name = name;
        this.seats = seats;
    }

    public String getName() {return name;}

    public String getSeats() {return seats;}

    }

