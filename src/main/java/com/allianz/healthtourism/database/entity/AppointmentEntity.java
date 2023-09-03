package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table
@Entity
@Data
public class AppointmentEntity extends BaseEntity {
    @Column(name = "appointment_date")
    private LocalDateTime appointmentDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hospital_id")
    private HospitalEntity hospital;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "health_service_id")
    private HealthCareServiceEntity healthService;
}
