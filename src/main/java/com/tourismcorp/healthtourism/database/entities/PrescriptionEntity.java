package com.tourismcorp.healthtourism.database.entities;

import com.tourismcorp.healthtourism.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class PrescriptionEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "doctor_entity_id", nullable = false)
    private DoctorEntity doctor;

    @Column
    private String prescription;

}
