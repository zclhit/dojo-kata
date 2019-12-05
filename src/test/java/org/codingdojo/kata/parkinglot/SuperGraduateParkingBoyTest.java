package org.codingdojo.kata.parkinglot;

import org.codingdojo.kata.parkinglot.Bean.Car;
import org.codingdojo.kata.parkinglot.Bean.Credit;
import org.codingdojo.kata.parkinglot.parkingboy.SuperParkingBoy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SuperGraduateParkingBoyTest {

    @Test
    public void should_park_in_first_parking_lot_when_the_first_parking_lot_has_higher_free_ratio() {
        SuperParkingBoy boy = initSuperParkingBoy(1, 0);
        Car car = new Car();
        Credit credit = boy.park(car);
        assertEquals(1, credit.getParkingLotNumber());
    }

    @Test
    public void should_park_in_second_parking_lot_when_the_second_parking_lot_has_higher_free_ratio() {
        SuperParkingBoy boy = initSuperParkingBoy(0, 1);
        Car car = new Car();
        Credit credit = boy.park(car);
        assertEquals(2, credit.getParkingLotNumber());
    }

    @Test
    public void should_park_in_first_parking_lot_when_the_first_parking_lot_has_higher_free_ratio_of_fraction() {
        SuperParkingBoy boy = initSuperParkingBoy(3, 4);
        Car car1 = new Car();
        Credit credit1 = boy.park(car1);
        assertEquals(1, credit1.getParkingLotNumber());
        Car car2 = new Car();
        Credit credit2 = boy.park(car2);
        assertEquals(2, credit2.getParkingLotNumber());
        Car car3 = new Car();
        Credit credit3 = boy.park(car3);
        assertEquals(2, credit3.getParkingLotNumber());
    }

    @Test
    public void should_park_in_p1_when_p1_and_p2_have_same_free_pos() {
        SuperParkingBoy boy = initSuperParkingBoy(1, 1);
        Car car = new Car();
        Credit credit = boy.park(car);
        assertEquals(1, credit.getParkingLotNumber());
    }

    @Test
    public void should_not_park_when_parking_lots_are_full() {
        SuperParkingBoy boy = initSuperParkingBoy(0, 0);
        Car car = new Car();
        Credit credit = boy.park(car);
        assertNull(credit);
    }

    @Test
    public void should_get_car_when_with_right_credit() {
        SuperParkingBoy boy = initSuperParkingBoy(1, 1);
        Car car = new Car();
        Credit credit = boy.park(car);
        assertEquals(car, boy.retrieveCar(credit));
    }

    @Test
    public void should_return_null_given_invalid_credit_when_retrieve_car() {
        SuperParkingBoy boy = initSuperParkingBoy(1, 1);
        Credit credit = new Credit(1, "dummy token");
        assertNull(boy.retrieveCar(credit));
    }

    private SuperParkingBoy initSuperParkingBoy(int firstLotSize, int secondLotSize) {
        SuperParkingBoy boy = new SuperParkingBoy();
        boy.addParkingLot(firstLotSize);
        boy.addParkingLot(secondLotSize);
        return boy;
    }
}
