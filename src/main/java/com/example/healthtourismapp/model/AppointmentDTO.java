package com.example.healthtourismapp.model;

import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppointmentDTO extends BaseDTO {

    private LocalDateTime date;
    private PatientDTO patient;
    private HotelDTO hotel;
    private FlightDTO flight;
    private HospitalDTO hospital;
    private double totalBill;
}
