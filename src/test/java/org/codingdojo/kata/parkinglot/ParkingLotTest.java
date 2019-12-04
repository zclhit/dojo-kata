package org.codingdojo.kata.parkinglot;

import org.codingdojo.kata.parkinglot.Bean.Car;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ParkingLotTest {

    @Test
    public void should_parked_car_and_return_card_when_customer_come_to_park_when_lot_has_free_position() {
        ParkingLot lot = new ParkingLot(2);
        Car car = new Car();
        String cardNumber = lot.park(car);

        assertNotNull(cardNumber);
    }

    @Test
    public void should_retrieve_car_success_given_customer_take_correct_card_when_he_come_to_retrieve() {
        ParkingLot lot = new ParkingLot(2);
        Car car = new Car();
        String cardNumber = lot.park(car);

        assertEquals(car, lot.retrieve(cardNumber));
    }

    @Test
    public void should_park_failed_given_lot_with_no_position_when_customer_come_to_park() {
        ParkingLot lot = new ParkingLot(0);
        Car car = new Car();

        String cardNumber = lot.park(car);

        assertNull(cardNumber);
    }

    @Test
    public void should_reduce_park_current_cap_by_1_when_parked_a_car_in() {
        ParkingLot lot = new ParkingLot(2);
        Car car1 = new Car();
        String cardNumber1 = lot.park(car1);
        Car car2 = new Car();
        String cardNumber2 = lot.park(car2);

        assertFalse(lot.hasFreePosition());
    }

    @Test
    public void should_retrieve_failed_given_not_exist_card_number_when_customer_retrieve_car() {
        ParkingLot lot = new ParkingLot(2);
        Car car = new Car();
        String cardNumber = UUID.randomUUID().toString();

        assertNull(lot.retrieve(cardNumber));
    }

    @Test
    public void should_retrieve_failed_given_null_card_number_when_customer_retrieve_car() {
        ParkingLot lot = new ParkingLot(2);
        Car car = new Car();

        assertNull(lot.retrieve(null));
    }

    @Test
    public void should_failed_when_retrieve_car_again() {
        ParkingLot lot = new ParkingLot(2);
        Car car = new Car();
        String cardNumber = lot.park(car);

        assertEquals(car, lot.retrieve(cardNumber));
        assertNull(lot.retrieve(cardNumber));
    }

}
