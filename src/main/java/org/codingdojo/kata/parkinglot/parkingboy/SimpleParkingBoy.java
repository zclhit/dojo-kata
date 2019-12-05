package org.codingdojo.kata.parkinglot.parkingboy;

import org.codingdojo.kata.parkinglot.Bean.Car;
import org.codingdojo.kata.parkinglot.Bean.Credit;
import org.codingdojo.kata.parkinglot.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public abstract class SimpleParkingBoy {
    List<ParkingLot> myParkingLots = new ArrayList<>();

    public void addParkingLot(int cap) {
        myParkingLots.add(new ParkingLot(cap));
    }

    public abstract Credit park(Car car);

    public Car retrieveCar(Credit credit) {
        int parkingLotNumber = credit.getParkingLotNumber();
        if (parkingLotNumber > myParkingLots.size() || parkingLotNumber == 0) {
            return null;
        }
        return myParkingLots.get(parkingLotNumber - 1).retrieve(credit.getParkingToken());
    }

    public boolean hasFreePos() {
        for (ParkingLot myParkingLot : myParkingLots) {
            if (myParkingLot.hasFreePosition()) {
                return true;
            }
        }
        return false;
    }
}
