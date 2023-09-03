package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "patients")
public class PatientEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @Column(unique = true)
    private String tc;

    @Column
    private String email;

    @ManyToOne
    private DoctorEntity doctor;

    @ManyToOne
    private FlightEntity flight;

    @OneToOne
    private AppointmentEntity appointment;

    @ManyToOne
    private HotelEntity hotel;

    @OneToOne
    private HealthcareEntity healthCare;
}