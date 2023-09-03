package com.allianz.healthtourism.model.DTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

@Data
public class PatientDTO extends BaseDTO {

    private String name;

    private String phoneNumber;

    private String tc;

    private String email;

    private DoctorDTO doctor;

    private FlightDTO flight;

    private AppointmentDTO appointment;

    private HotelDTO hotel;

    private HealthCareDTO healthCare;
}
