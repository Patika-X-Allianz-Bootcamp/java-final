package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "appointments")
public class AppointmentEntity extends BaseEntity {

    @Column
    private LocalDateTime appointmentDateTime;

    @ManyToOne
    private DoctorEntity doctor;

    @OneToOne
    private PatientEntity patient;
    private boolean isAccepted = false;
}