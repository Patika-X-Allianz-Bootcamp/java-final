package com.aslihanhasar.medicaltourismapp.exception;

public class PatientAlreadyHasAppointmentException extends RuntimeException {
    public PatientAlreadyHasAppointmentException(String message) {
        super(message);
    }
}
