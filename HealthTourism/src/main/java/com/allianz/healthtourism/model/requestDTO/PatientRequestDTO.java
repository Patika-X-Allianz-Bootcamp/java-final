package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

@Data
public class PatientRequestDTO extends BaseDTO {

    private String name;

    private String phoneNumber;

    private String tc;

    private String email;

    private DoctorRequestDTO doctor;

    private FlightRequestDTO flight;

    private AppointmentRequestDTO appointment;

    private HotelRequestDTO hotel;

    private HealthCareRequestDTO healthCare;
}
