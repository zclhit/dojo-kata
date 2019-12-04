package org.codingdojo.kata.parkinglot.parkingboy;

import org.codingdojo.kata.parkinglot.Bean.Car;
import org.codingdojo.kata.parkinglot.Bean.Credit;
import org.codingdojo.kata.parkinglot.ParkingLot;

import java.util.Comparator;

public class SuperParkingBoy extends SimpleParkingBoy {
    @Override
    public Credit park(Car car) {
        return getCredit(car);
    }

    private Credit getCredit(Car car) {
        float maxFreePosRatio = myParkingLots.stream()
                .map(ParkingLot::getFreeRatio)
                .max(Comparator.naturalOrder())
                .orElse(0f);
        if (maxFreePosRatio == 0f) {
            return null;
        }
        for (ParkingLot parkingLot : myParkingLots) {
            if (parkingLot.getFreeRatio() == maxFreePosRatio) {
                return new Credit(myParkingLots.indexOf(parkingLot) + 1, parkingLot.park(car));
            }
        }
        return null;
    }
}
