package com.playtika.automation.tasks.oop;

public class Car extends Transport {

    String transmission;

    public Car(String carBrand, String carModel, String bodyType, double weight, double maxSpeed, String colour, Engine engine, String transmission) {
        super(carBrand, carModel, bodyType, weight, maxSpeed, colour, engine);
        this.transmission = transmission;
    }


    @Override
    public String toString() {
        return "Car{" +
                " brand: '" + brand + '\'' +
                ", model: '" + model + '\'' +
                ", body type: '" + bodyType + '\'' +
                ", weight: " + weight +" kg"+
                ", max speed: " + maxSpeed + " km/h"+
                ", colour: '" + colour + '\'' +
                ", transmission: '" + transmission + '\'' +
                ", " + engine +
                '}';
    }
}
