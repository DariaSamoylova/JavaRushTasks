package com.javarush.task.task29.task2909.car;

/**
 * Created by mr_ma on 04.11.2017.
 */
public class Truck extends  Car {
    private final int MAX_TRUCK_SPEED=80;
    public Truck(  int numberOfPassengers) {
        super(0, numberOfPassengers);
    }

    public   int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}
