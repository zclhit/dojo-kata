package org.codingdojo.kata.parkinglot.Bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Credit {
    private int parkingLotNumber;
    private String parkingToken;

    public Credit(int parkingLotNumber, String parkingToken) {
        this.parkingLotNumber = parkingLotNumber;
        this.parkingToken = parkingToken;
    }
}
