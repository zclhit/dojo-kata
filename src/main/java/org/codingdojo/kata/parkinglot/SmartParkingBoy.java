package org.codingdojo.kata.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy{

    private List<ParkingLot> myParkingLots = new ArrayList<>();

    public void addParkingLot(int cap) {
        myParkingLots.add(new ParkingLot(cap));
    }

    public Credit park(Car car) {
        ParkingLot lot1 = myParkingLots.get(0);
        ParkingLot lot2 = myParkingLots.get(1);
        int freePosOfLot1 = lot1.getFreePos();
        int freePosOfLot2 = lot2.getFreePos();

        if (freePosOfLot1 > freePosOfLot2) {
            return new Credit(1, lot1.park(car));
        } else if (freePosOfLot1 < freePosOfLot2) {
            return new Credit(2, lot2.park(car));
        } else if (freePosOfLot1 > 0) {
            return new Credit(1, lot1.park(car));
        } else {
            return null;
        }
    }

    public Car retrieveCar(Credit credit) {
        int parkingLotNumber = credit.getParkingLotNumber();
        if (parkingLotNumber > myParkingLots.size()) {
            return null;
        }
        return myParkingLots.get(parkingLotNumber - 1).retrieve(credit.getParkingToken());
    }
}
