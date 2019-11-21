package org.codingdojo.kata.ruler;

import org.codingdojo.kata.ruler.enu.LengthUnit;
import org.codingdojo.kata.ruler.exception.TooLongException;

public class Length {

    private final long MAX_LENGTH = 1000000L;

    private long length;

    private LengthUnit unit;

    public Length(String length, String unit) throws RuntimeException{
        this.length = Long.parseLong(length);
        this.unit = LengthUnit.parseUnit(unit);
        if (this.length * this.unit.getScale() > MAX_LENGTH) {
            throw new TooLongException("too long");
        }
    }

    public int compareTo(Length length) {
        Long length1 = getLength(this);
        Long length2 = getLength(length);

        return length1.compareTo(length2);
    }

    private long getLength(Length length) {
        return length.length * length.unit.getScale();
    }

    @Override
    public String toString() {
        return length + unit.getName();
    }
}
