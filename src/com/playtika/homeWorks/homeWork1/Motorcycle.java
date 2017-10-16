package com.playtika.homeWorks.homeWork1;

public class Motorcycle extends Transport {

    String rearWheelDrive;

    public Motorcycle(String brand, String model, String bodyType, double weight, double maxSpeed, String colour, Engine engine, String rearWheelDrive) {
        super(brand, model, bodyType, weight, maxSpeed, colour, engine);
        this.rearWheelDrive = rearWheelDrive;
    }
}
