package com.healthtourism.healthtourism.database.entities;

import com.healthtourism.healthtourism.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class DoctorEntity extends BaseEntity {
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String specialization;

    @ManyToMany
    @JoinTable(name = "doctor_patient",
            joinColumns = {@JoinColumn(name = "doctor_id")},
            inverseJoinColumns = {@JoinColumn(name = "patient_id")}
    )
    private List<PatientEntity> patients;
}
