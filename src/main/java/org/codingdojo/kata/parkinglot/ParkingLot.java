package org.codingdojo.kata.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
    private final int cap;
    private int currentCap;
    private Map<String, Car> map = new HashMap<>();

    public ParkingLot(int cap) {
        this.cap = cap;
        this.currentCap = cap;
    }

    public String park(org.codingdojo.kata.parkinglot.Car car) {
        if (currentCap == 0) {
            return null;
        }

        if (null == car.getPlateNumber()) {
            return null;
        }

        String cardNumber = UUID.randomUUID().toString();
        map.put(cardNumber, car);
        currentCap--;
        return cardNumber;
    }

    public Car retrieve(String cardNumber) {
        Car car = map.get(cardNumber);
        map.remove(cardNumber);
        return car;
    }

    public int getCurrentCap() {
        return currentCap;
    }
}
