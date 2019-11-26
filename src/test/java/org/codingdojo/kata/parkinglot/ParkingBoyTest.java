package org.codingdojo.kata.parkinglot;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ParkingBoyTest {
    private ParkingBoy boy = new ParkingBoy();

    @Before
    public void init_park_boy() {
        boy.addParkingLot(30);
        boy.addParkingLot(50);
    }

    @Test
    public void should_park_in_first_parking_lot_when_the_first_parking_lot_has_empty_pos() {
        Car car = new Car("陕A 12345");
        Credit credit = boy.park(car);
        assertEquals(1, credit.getParkingLotNumber());
    }

    @Test
    public void should_park_in_second_parking_lot_when_the_first_parking_lot_is_full() {
        for (int i = 0; i<30 ; i ++) {
            Car car = new Car("陕A 1234"+i);
            boy.park(car);
        }
        Car car = new Car("陕A 22345");
        Credit credit = boy.park(car);
        assertEquals(2, credit.getParkingLotNumber());
    }

    @Test
    public void should_not_park_when_parking_lots_are_full() {
        for (int i = 0; i<30 ; i ++) {
            Car car = new Car("陕A 1234"+i);
            boy.park(car);
        }
        for (int i = 0; i<50 ; i ++) {
            Car car = new Car("陕A 2234"+i);
            boy.park(car);
        }
        Car car = new Car("陕A 32345");
        Credit credit = boy.park(car);
        assertNull(credit);
    }

//    @Test
//    public void should_get_car_when_with_right_credit() {
//        Car car = new Car("陕A 12345");
//        Credit credit = boy.park(car);
//        assertEquals(1, credit.getParkingLotNumber());
//    }
}

