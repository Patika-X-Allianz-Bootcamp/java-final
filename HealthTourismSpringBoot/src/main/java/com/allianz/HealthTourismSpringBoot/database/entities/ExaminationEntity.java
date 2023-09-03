package com.allianz.HealthTourismSpringBoot.database.entities;

import com.allianz.HealthTourismSpringBoot.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table
@Data
public class ExaminationEntity extends BaseEntity {

    @Column(nullable = false)
    private String medicalTreatment;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date examinationDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "client_id",nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "doctor_id",nullable = false)
    private DoctorEntity doctor;
}
