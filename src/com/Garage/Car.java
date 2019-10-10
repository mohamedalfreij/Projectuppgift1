package com.Garage;

public class Car extends Vehicle {
    private String model;
    private int topSpeed;


    public Car(String name, String seats, String model, int topSpeed){
        super(name, seats);
        this.model = model;
        this.topSpeed = topSpeed;
    }

    public String getModel() { return model; }

    public int getTopSpeed() {
        return topSpeed;
    }



    public static Car createCar(String name, String seats, String model , int topSpeed){
        Car car = new Car(name, seats, model, topSpeed);
        return car;}
}

