package com.allianz.healthtourismagency.database.entity;

import com.allianz.healthtourismagency.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "medicalReports")
@Data
public class MedicalReportEntity extends BaseEntity {

    @Column
    public String diagnosis;

    @Column
    public String treatment;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<MedicationEntity> medicationList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<TestResultEntity> testResultList;

}
