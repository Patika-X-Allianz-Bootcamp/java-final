package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class DoctorEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @OneToOne
    private HealthCareEntity healthCare;

    @ManyToOne
    private HospitalEntity hospital;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private List<PatientEntity> patientEntityList;

    @OneToMany(mappedBy = "doctor")
    private List<AppointmentEntity> appointmentList;
}
