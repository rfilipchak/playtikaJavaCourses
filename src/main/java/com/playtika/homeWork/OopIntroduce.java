package com.playtika.homeWork;

public class OopIntroduce {
    public static void main(String[] args) {

        Car ford = new Car("Ford", "Mustang", "Coupe", 1750, 276, "Red", new Engine("V12", 12, 450), "automatic");
        Motorcycle kawasaki = new Motorcycle("Kawasaki", "ZZR-600", "Sport Turrer", 175, 235, "Grey", new Engine("in-line engine 600 CC", 4, 100), "chain drive");

        System.out.println(ford.toString());
        System.out.println(kawasaki.toString());

        kawasaki.startEngine();
        kawasaki.startEngine();
        kawasaki.stopEgine();
        kawasaki.stopEgine();
    }

}
