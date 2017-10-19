package com.playtika.homeWork;

public class Engine {
    String engineType;
    int numberOfCylinders;
    int hoursePowers;
    boolean isStarted;
    boolean isStoped = true;

    public Engine(String engineType, int numberOfCylinders, int hoursePowers) {
        this.engineType = engineType;
        this.numberOfCylinders = numberOfCylinders;
        this.hoursePowers = hoursePowers;
    }

    @Override
    public String toString() {
        return
                " engine type: '" + engineType + '\'' +
                ", number of cylinders: " + numberOfCylinders +
                ", hourse howers: " + hoursePowers + "Hp";
    }

}
