package org.codingdojo.kata.parkinglot;

import org.codingdojo.kata.parkinglot.Bean.Car;
import org.codingdojo.kata.parkinglot.Bean.Credit;
import org.codingdojo.kata.parkinglot.parkingboy.SmartParkingBoy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SmartGraduateParkingBoyTest {

    @Test
    public void should_park_in_first_parking_lot_when_the_first_parking_lot_has_more_free_pos() {
        SmartParkingBoy boy = initSmartParkingBody(1, 0);
        Car car = new Car();
        Credit credit = boy.park(car);
        assertEquals(1, credit.getParkingLotNumber());
    }

    @Test
    public void should_park_in_second_parking_lot_when_the_second_parking_lot_has_more_free_pos() {
        SmartParkingBoy boy = initSmartParkingBody(0, 1);
        Car car = new Car();
        Credit credit = boy.park(car);
        assertEquals(2, credit.getParkingLotNumber());
    }

    @Test
    public void should_park_in_p1_when_p1_and_p2_have_same_free_pos() {
        SmartParkingBoy boy = initSmartParkingBody(1, 1);
        Car car = new Car();
        Credit credit = boy.park(car);
        assertEquals(1, credit.getParkingLotNumber());
    }

    @Test
    public void should_not_park_when_parking_lots_are_full() {
        SmartParkingBoy boy = initSmartParkingBody(0, 0);
        Car car = new Car();
        Credit credit = boy.park(car);
        assertNull(credit);
    }

    @Test
    public void should_get_car_when_with_right_credit() {
        SmartParkingBoy boy = initSmartParkingBody(1, 1);
        Car car = new Car();
        Credit credit = boy.park(car);
        assertEquals(car, boy.retrieveCar(credit));
    }

    @Test
    public void should_return_null_given_invalid_credit_when_retrieve_car() {
        SmartParkingBoy boy = initSmartParkingBody(1, 1);
        Credit credit = new Credit(1, "dummy token");
        assertNull(boy.retrieveCar(credit));
    }

    private SmartParkingBoy initSmartParkingBody(int firstLotSize, int secondLotSize) {
        SmartParkingBoy boy = new SmartParkingBoy();
        boy.addParkingLot(firstLotSize);
        boy.addParkingLot(secondLotSize);
        return boy;
    }
}

