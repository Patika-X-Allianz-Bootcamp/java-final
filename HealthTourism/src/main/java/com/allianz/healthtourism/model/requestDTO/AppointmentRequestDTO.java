package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequestDTO extends BaseDTO {

    private LocalDateTime appointmentDateTime;

    private DoctorRequestDTO doctor;

    private PatientRequestDTO patient;
}
