package com.aslihanhasar.medicaltourismapp.exception;

public class AppointmentAlreadyConfirmedException extends RuntimeException {
    public AppointmentAlreadyConfirmedException(String message) {
        super(message);
    }
}
