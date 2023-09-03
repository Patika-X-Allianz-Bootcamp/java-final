package com.patika.healthtourism.model;

import com.patika.healthtourism.database.entity.DoctorEntity;
import com.patika.healthtourism.database.entity.PatientEntity;
import com.patika.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO extends BaseDTO {
    private HospitalDTO hospital;
    private HealthServiceDTO healthService;
    private DoctorDTO doctor;
    private PatientDTO patient;
    private LocalDateTime appointmentDateTime;
    private Boolean confirmed;
}
