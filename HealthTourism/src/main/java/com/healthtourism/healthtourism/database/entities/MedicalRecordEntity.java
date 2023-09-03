package com.healthtourism.healthtourism.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.healthtourism.healthtourism.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
@Entity
@Table
@Data
public class MedicalRecordEntity extends BaseEntity {

    @Column
    private LocalDateTime examinationDateTime=LocalDateTime.now();
    @Column
    private String examinationNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_entity_id", nullable = false)
    @JsonIgnore
    private PatientEntity patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_entity_id", nullable = false)
    @JsonIgnore
    private DoctorEntity doctor;
}
