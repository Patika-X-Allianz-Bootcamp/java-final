package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class HospitalEntity extends BaseEntity {
    private String name;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private CityEntity city;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<ExaminationRecordEntity> examinationRecords;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<PatientEntity> patients;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "hospital")
    private List<DoctorEntity> doctors;
    @ManyToMany(mappedBy = "hospitals", cascade = CascadeType.MERGE)
    private List<HealthCareServiceEntity> healthCareServices;
}
