package com.aslihanhasar.medicaltourismapp.exception;

public class HotelReservationAlreadyConfirmedException extends RuntimeException {
    public HotelReservationAlreadyConfirmedException(String message) {
        super(message);
    }
}
