package org.codingdojo.kata.parkinglot.parkingboy;

import org.codingdojo.kata.parkinglot.Bean.Car;
import org.codingdojo.kata.parkinglot.Bean.Credit;

import java.util.Arrays;
import java.util.List;

public class ParkingManager extends GraduateParkingBoy {
    private List<SimpleParkingBoy> parkingBoys;

    public ParkingManager(SimpleParkingBoy... parkingBoys) {
        this.parkingBoys = Arrays.asList(parkingBoys);
    }

    public void addParkingBoy(SimpleParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    @Override
    public Credit park(Car car) {
        for (SimpleParkingBoy parkingBoy : parkingBoys) {
            if (parkingBoy.hasFreePos()) {
                return parkingBoy.park(car);
            }
        }
        if (this.hasFreePos()) {
            return super.park(car);
        }
        return null;
    }

    @Override
    public Car retrieveCar(Credit credit) {
        for (SimpleParkingBoy parkingBoy : parkingBoys) {
            Car car =  parkingBoy.retrieveCar(credit);
            if ( car != null) {
                return car;
            }
        }
        return super.retrieveCar(credit);
    }
}
