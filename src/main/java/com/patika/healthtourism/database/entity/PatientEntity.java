package com.patika.healthtourism.database.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.patika.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Data
@Table
public class PatientEntity extends BaseEntity {
    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column(columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    @Column
    private String phoneNumber;
    @Column
    private String email;

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<ExaminationEntity> examinations;

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<AppointmentEntity> appointments;

    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<TravelPlanEntity> travelPlans;
}
