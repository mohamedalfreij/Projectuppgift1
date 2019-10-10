package com.Garage;

public class Mc extends Vehicle {

    private String name;
    private int model;
    private int topSpeed;


    public Mc(String name, int model, int topSpeed){
        super("fordon: ","antal säten: ");
        this.name = name;
        this.model = model;
        this.topSpeed = topSpeed;

    }

    @Override
    public String getSeats() {
        return super.getSeats();
    }
    @Override
    public String getName() {
        return super.getName();
    }
}
