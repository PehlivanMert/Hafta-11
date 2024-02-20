package dev.patika.librarymanagmentsystemwithrestapi.core.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
