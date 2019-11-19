package org.codingdojo.kata;

import org.codingdojo.kata.exception.TooLongException;

public class Thing {
    private int start;
    private int end;

    private static int MAX_LENGTH = 200;

    public Thing(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int length() throws TooLongException {
        if (this.end - this.start >= MAX_LENGTH) {
            throw new TooLongException("too long");
        } else {
            return this.end - this.start;
        }
    }
}
