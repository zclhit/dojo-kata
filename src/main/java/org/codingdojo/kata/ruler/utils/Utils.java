package org.codingdojo.kata.ruler.utils;

import org.codingdojo.kata.ruler.enu.LengthUnit;

public class Utils {
    public static boolean validLengthString(String[] lengthArray) {
        if (2 != lengthArray.length) {
            return false;
        }
        if (Long.parseLong(lengthArray[0]) < 0L ) {
            return false;
        }
        return LengthUnit.validUnit(lengthArray[1]);
    }
}
