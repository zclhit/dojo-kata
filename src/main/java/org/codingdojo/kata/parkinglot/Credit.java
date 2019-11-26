package org.codingdojo.kata.parkinglot;

public class Credit {
    private int parkingLotNumber;
    private String parkingToken;

    public Credit(int parkingLotNumber, String parkingToken) {
        this.parkingLotNumber = parkingLotNumber;
        this.parkingToken = parkingToken;
    }

    public int getParkingLotNumber() {
        return parkingLotNumber;
    }

    public void setParkingLotNumber(int parkingLotNumber) {
        this.parkingLotNumber = parkingLotNumber;
    }

    public String getParkingToken() {
        return parkingToken;
    }

    public void setParkingToken(String parkingToken) {
        this.parkingToken = parkingToken;
    }
}
