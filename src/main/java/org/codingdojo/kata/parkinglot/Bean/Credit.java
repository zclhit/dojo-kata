package org.codingdojo.kata.parkinglot.Bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Credit {
    private int parkingLotNumber;
    private String parkingToken;
}
