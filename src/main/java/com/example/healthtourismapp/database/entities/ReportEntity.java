package com.example.healthtourismapp.database.entities;

import com.example.healthtourismapp.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

@Entity
@Table
@Data
public class ReportEntity extends BaseEntity {

    @OneToOne
    private DoctorEntity doctor;

    @OneToOne
    private PatientEntity patient;

    @Column(columnDefinition = "text", nullable = false)
    private String content;

    @Column
    private Date date;


}
