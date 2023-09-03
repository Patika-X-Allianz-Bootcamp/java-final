package com.allianz.healthtourismagency.database.entity;

import com.allianz.healthtourismagency.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class PatientEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String identityNumber;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalReportEntity> medicalReportList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AppointmentEntity> appointmentHistory;

}
