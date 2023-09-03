package com.patika.healthtourism.database.entity;

import com.patika.healthtourism.model.enums.SpecializationEnum;
import com.patika.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table
@Data
public class DoctorEntity extends BaseEntity {
    @Column
    private String firstName;
    @Column
    private String lastName;

    @Enumerated(EnumType.STRING)
    private SpecializationEnum specialization;
    @Column
    private LocalDateTime birthDate;
    @Column
    private String phoneNumber;
    @Column
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private HealthServiceEntity healthService;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<ExaminationEntity> examinations;
}
