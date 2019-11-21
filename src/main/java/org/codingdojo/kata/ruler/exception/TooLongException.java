package org.codingdojo.kata.ruler.exception;

public class TooLongException extends RuntimeException {
    public TooLongException(String message) {
        super(message);
    }
}
