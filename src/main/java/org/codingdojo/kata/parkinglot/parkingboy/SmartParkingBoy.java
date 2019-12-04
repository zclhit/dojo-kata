package org.codingdojo.kata.parkinglot.parkingboy;

import org.codingdojo.kata.parkinglot.Bean.Car;
import org.codingdojo.kata.parkinglot.Bean.Credit;
import org.codingdojo.kata.parkinglot.ParkingLot;

import java.util.Comparator;

public class SmartParkingBoy extends SimpleParkingBoy{
    @Override
    public Credit park(Car car) {
        return getCredit(car);
    }

    private Credit getCredit(Car car) {
        int maxFreePosNum = myParkingLots.stream()
                .map(ParkingLot::getFreePos)
                .max(Comparator.naturalOrder())
                .orElse(0);
        if (maxFreePosNum == 0) {
            return null;
        }
        for (ParkingLot parkingLot : myParkingLots) {
            if (parkingLot.getFreePos() == maxFreePosNum) {
                return new Credit(myParkingLots.indexOf(parkingLot) + 1, parkingLot.park(car));
            }
        }
        return null;
    }
}
