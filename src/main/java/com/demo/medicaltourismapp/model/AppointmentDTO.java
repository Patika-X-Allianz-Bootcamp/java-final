package com.demo.medicaltourismapp.model;

import com.demo.medicaltourismapp.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AppointmentDTO extends BaseDTO {
    private List<FlightDTO> flights;
    private HotelDTO hotel;
    private DoctorDTO doctor;
    private HospitalDTO hospital;
    private int hotelStayDurationInDays;
    private LocalDate reservationStartDay;
    private String doctorsNotes;
}
