package org.codingdojo.kata.parkinglot.parkingboy;

import org.codingdojo.kata.parkinglot.Bean.Car;
import org.codingdojo.kata.parkinglot.Bean.Credit;
import org.codingdojo.kata.parkinglot.ParkingLot;

public class ParkingBoy extends SimpleParkingBoy{
    @Override
    public Credit park(Car car) {
        for (int i=0; i<myParkingLots.size(); i++) {
            ParkingLot lot = myParkingLots.get(i);
            if (lot.hasFreePosition()) {
                return new Credit(i + 1, lot.park(car));
            }
        }
        return null;
    }
}
