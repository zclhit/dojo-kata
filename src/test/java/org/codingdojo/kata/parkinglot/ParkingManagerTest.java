package org.codingdojo.kata.parkinglot;

import org.codingdojo.kata.parkinglot.Bean.Car;
import org.codingdojo.kata.parkinglot.Bean.Credit;
import org.codingdojo.kata.parkinglot.parkingboy.GraduateParkingBoy;
import org.codingdojo.kata.parkinglot.parkingboy.ParkingManager;
import org.codingdojo.kata.parkinglot.parkingboy.SmartParkingBoy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ParkingManagerTest {
    @Test
    public void should_park_by_first_parking_boy_when_the_first_parking_boy_has_free_parking_lot() {
        ParkingManager manager = new ParkingManager();
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy();
        graduateParkingBoy.addParkingLot(1);
        manager.addParkingBoy(graduateParkingBoy);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.addParkingLot(1);
        manager.addParkingBoy(smartParkingBoy);

        Car car = new Car();
        Credit credit = manager.park(car);
        assertEquals(car, graduateParkingBoy.retrieveCar(credit));
        assertNull(smartParkingBoy.retrieveCar(credit));
    }

    @Test
    public void should_retrieve_by_manager_if_parking_boy_has_free_pos() {
        ParkingManager manager = new ParkingManager();
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy();
        graduateParkingBoy.addParkingLot(1);
        manager.addParkingBoy(graduateParkingBoy);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.addParkingLot(1);
        manager.addParkingBoy(smartParkingBoy);

        Car car = new Car();
        Credit credit = manager.park(car);
        assertEquals(car, manager.retrieveCar(credit));
    }

    @Test
    public void should_park_by_second_parking_boy_when_the_first_parking_boy_has_not_free_parking_lot_but_the_second_parking_boy_has_not_free_parking_lot() {
        ParkingManager manager = new ParkingManager();
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy();
        graduateParkingBoy.addParkingLot(0);
        manager.addParkingBoy(graduateParkingBoy);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.addParkingLot(1);
        manager.addParkingBoy(smartParkingBoy);

        Car car = new Car();
        Credit credit = manager.park(car);
        assertEquals(car, smartParkingBoy.retrieveCar(credit));
    }

    @Test
    public void should_park_by_manager_when_all_parking_boys_has_no_free_parking_lot() {
        ParkingManager manager = new ParkingManager();
        manager.addParkingLot(1);
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy();
        graduateParkingBoy.addParkingLot(0);
        manager.addParkingBoy(graduateParkingBoy);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.addParkingLot(0);
        manager.addParkingBoy(smartParkingBoy);

        Car car = new Car();
        Credit credit = manager.park(car);
        assertEquals(car, manager.retrieveCar(credit));
    }

    @Test
    public void should_return_null_when_all_parking_boys_and_manager_have_no_free_parking_lot() {
        ParkingManager manager = new ParkingManager();
        manager.addParkingLot(0);
        GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy();
        graduateParkingBoy.addParkingLot(0);
        manager.addParkingBoy(graduateParkingBoy);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.addParkingLot(0);
        manager.addParkingBoy(smartParkingBoy);

        Car car = new Car();
        Credit credit = manager.park(car);
        assertNull(credit);
    }

    @Test
    public void should_return_right_car_when_retrieve_car_with_right_credit() {
        ParkingManager manager = new ParkingManager();
        manager.addParkingLot(2);

        Car car = new Car();
        Credit credit = manager.park(car);
        Car takeCar = manager.retrieveCar(credit);
        assertEquals(car, takeCar);
    }

    @Test
    public void should_return_null_when_retrieve_car_with_wrong_credit() {
        ParkingManager manager = new ParkingManager();
        manager.addParkingLot(2);

        Car takeCar = manager.retrieveCar(new Credit());
        assertNull(takeCar);
    }
}
