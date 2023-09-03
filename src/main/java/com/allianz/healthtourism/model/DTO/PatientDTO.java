package com.allianz.healthtourism.model.DTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class PatientDTO extends BaseDTO {
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String password;
    private ReservationDTO reservation;
    private AppointmentDTO appointment;
    private List<ReportDTO> reports;
}