package com.allianz.patienttourism.database.entity;

import com.allianz.patienttourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "examination_reports")
@Data
public class ExaminationReport extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "report")
    private String report;

}
