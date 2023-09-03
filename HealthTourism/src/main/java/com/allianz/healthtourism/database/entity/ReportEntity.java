package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reports")
public class ReportEntity extends BaseEntity {
        @ManyToOne
        private PatientEntity patient;

        @ManyToOne(fetch = FetchType.LAZY)
        private DoctorEntity doctor;

        @Column
        private String detail;
}
