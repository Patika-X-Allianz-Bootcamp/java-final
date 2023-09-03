package com.patika.healthtourism.model;

import com.patika.healthtourism.database.entity.AppointmentEntity;
import com.patika.healthtourism.database.entity.DoctorEntity;
import com.patika.healthtourism.database.entity.PatientEntity;
import com.patika.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExaminationDTO extends BaseDTO {
    private DoctorDTO doctor;
    private PatientDTO patient;
    private AppointmentDTO appointment;
    private LocalDateTime examinationDateTime;
    private String notes;
}
