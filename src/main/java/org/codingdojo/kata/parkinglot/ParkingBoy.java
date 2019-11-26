package org.codingdojo.kata.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    List<ParkingLot> myParkingLots = new ArrayList<>();

    public void addParkingLot(int cap) {
        myParkingLots.add(new ParkingLot(cap));
    }

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
