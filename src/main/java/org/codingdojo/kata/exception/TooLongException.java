package org.codingdojo.kata.exception;

public class TooLongException extends RuntimeException {
    public TooLongException(String message) {
        super(message);
    }
}
