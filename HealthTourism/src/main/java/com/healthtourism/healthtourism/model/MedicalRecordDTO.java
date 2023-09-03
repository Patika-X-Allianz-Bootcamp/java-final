package com.healthtourism.healthtourism.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.healthtourism.healthtourism.database.entities.DoctorEntity;
import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.time.LocalDateTime;
@Data
public class MedicalRecordDTO extends BaseDTO {
    private LocalDateTime examinationDateTime;
    private String examinationNotes;
    private PatientDTO patient;
    private DoctorDTO doctor;
}
