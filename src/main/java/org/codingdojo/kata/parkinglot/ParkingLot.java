package org.codingdojo.kata.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
    private final int cap;
    private Map<String, Car> map = new HashMap<>();

    public ParkingLot(int cap) {
        this.cap = cap;
    }

    public String park(org.codingdojo.kata.parkinglot.Car car) {
        if (!hasFreePosition()) {
            return null;
        }

        if (null == car.getPlateNumber()) {
            return null;
        }

        String cardNumber = UUID.randomUUID().toString();
        map.put(cardNumber, car);
        return cardNumber;
    }

    public Car retrieve(String cardNumber) {
        Car car = map.get(cardNumber);
        map.remove(cardNumber);
        return car;
    }

    public boolean hasFreePosition() {
        return map.keySet().size() < cap;
    }
}
