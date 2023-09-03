package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbutil.BaseEntity;
import com.allianz.healthtourism.util.security.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class DoctorEntity extends PersonEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private HospitalEntity hospital;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "health_care_service_id")
    private HealthCareServiceEntity healthCareService;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<ExaminationRecordEntity> examinationRecords;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "doctor")
    private List<AppointmentEntity> appointments;
}
