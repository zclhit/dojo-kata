package org.codingdojo.kata.parkinglot;

import org.codingdojo.kata.parkinglot.Bean.Car;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
    private final int cap;
    private Map<String, Car> map = new HashMap<>();

    public ParkingLot(int cap) {
        this.cap = cap;
    }

    public String park(Car car) {
        if (!hasFreePosition()) {
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

    public int getFreePos() {
        return cap - map.keySet().size();
    }

    public float getFreeRatio() {
        if (cap == 0) {
            return 0;
        }
        return (float)getFreePos() / (float)cap;
    }

    public boolean hasFreePosition() {
        return map.keySet().size() < cap;
    }
}
