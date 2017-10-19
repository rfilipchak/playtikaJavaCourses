package com.playtika.homeWork;

public abstract class Transport {
    String brand;
    String model;
    String bodyType;
    double weight;
    double maxSpeed;
    String colour;
    Engine engine;

    public Transport(String brand, String model, String bodyType, double weight, double maxSpeed, String colour, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.bodyType = bodyType;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.colour = colour;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", Body Type='" + bodyType + '\'' +
                ", Weight=" + weight +
                ", Max Speed=" + maxSpeed +
                ", Colour='" + colour + '\'' +
                ", Engine = " + engine +
                '}';
    }

    public void startEngine() {
        if (engine.isStarted == false) {
            System.out.println(brand + " " + model +": Engine started");
            engine.isStarted = true;
        } else {
            System.out.println(brand + " " + model + ": Stop the engine first");
        }
    }

    public void stopEgine(){
        if (engine.isStoped == false) {
            System.out.println(brand + " " + model + ": Engine stoped");
            engine.isStoped = true;
        } else {
            System.out.println(brand + " " + model + ": Engine stoped");
        }
    }
}

