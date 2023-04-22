package ru.lysanov.egor.homework2_4.exceptions;

public class WrongPasswordsException extends RuntimeException {
    public WrongPasswordsException(String message) {
        super(message);
    }
}
