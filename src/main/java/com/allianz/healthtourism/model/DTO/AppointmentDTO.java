package com.allianz.healthtourism.model.DTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO extends BaseDTO {

    private DoctorDTO doctor;
    private PatientDTO patient;
    private LocalDateTime reservationDate;
    private boolean isAccepted = false;
}