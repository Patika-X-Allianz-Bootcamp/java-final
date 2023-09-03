package com.demo.medicaltourismapp.database.entity;

import com.demo.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "patient_id"
        )
)
public class PatientEntity extends BaseEntity {

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AppointmentEntity> appointmentList;

    // this will be used for the reservation timer
    @Column
    private boolean isSessionActive;
}
