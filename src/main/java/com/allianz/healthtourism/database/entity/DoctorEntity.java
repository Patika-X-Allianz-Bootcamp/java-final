package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
@Table
public class DoctorEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @OneToOne
    private HealthcareEntity healthCare;

    @ManyToOne
    private HospitalEntity hospital;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private List<PatientEntity> patientEntityList;

    @OneToMany(mappedBy = "doctor")
    private List<AppointmentEntity> appointmentList;
}