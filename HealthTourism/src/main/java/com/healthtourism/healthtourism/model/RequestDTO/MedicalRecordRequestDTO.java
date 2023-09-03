package com.healthtourism.healthtourism.model.RequestDTO;

import com.healthtourism.healthtourism.database.entities.DoctorEntity;
import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.model.DoctorDTO;
import com.healthtourism.healthtourism.model.PatientDTO;
import com.healthtourism.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data

public class MedicalRecordRequestDTO extends BaseDTO {
    private LocalDateTime examinationDateTime;
    private String examinationNotes;
    private PatientDTO patient;
    private DoctorDTO doctor;
}
