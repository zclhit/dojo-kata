package org.codingdojo.kata.parkinglot;

import org.codingdojo.kata.parkinglot.Bean.Car;
import org.codingdojo.kata.parkinglot.Bean.Credit;
import org.codingdojo.kata.parkinglot.parkingboy.ParkingBoy;
import org.codingdojo.kata.parkinglot.parkingboy.SimpleParkingBoy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ParkingBoyTest {
    private SimpleParkingBoy boy = new ParkingBoy();

    @Before
    public void init_park_boy() {
        boy.addParkingLot(30);
        boy.addParkingLot(50);
    }

    @Test
    public void should_park_in_first_parking_lot_when_the_first_parking_lot_has_empty_pos() {
        Car car = new Car();
        Credit credit = boy.park(car);
        assertEquals(1, credit.getParkingLotNumber());
    }

    @Test
    public void should_park_in_second_parking_lot_when_the_first_parking_lot_is_full() {
        for (int i = 0; i<30 ; i ++) {
            Car car = new Car();
            boy.park(car);
        }
        Car car = new Car();
        Credit credit = boy.park(car);
        assertEquals(2, credit.getParkingLotNumber());
    }

    @Test
    public void should_not_park_when_parking_lots_are_full() {
        for (int i = 0; i<30 ; i ++) {
            Car car = new Car();
            boy.park(car);
        }
        for (int i = 0; i<50 ; i ++) {
            Car car = new Car();
            boy.park(car);
        }
        Car car = new Car();
        Credit credit = boy.park(car);
        assertNull(credit);
    }

    @Test
    public void should_get_car_when_with_right_credit() {
        Car car = new Car();
        Credit credit = boy.park(car);
        assertEquals(car, boy.retrieveCar(credit));
    }

    @Test
    public void should_return_null_given_invalid_credit_when_retrieve_car() {
        Credit credit = new Credit(1, "dummy token");
        assertNull(boy.retrieveCar(credit));
    }
}

