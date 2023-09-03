package com.allianz.medicaltourismapp.database.entity;

import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "patients")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "patient_uuid"
        )
)
public class PatientEntity extends PersonEntity {

    @Column
    private String prescription;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AppointmentEntity> appointments;

    @OneToMany
    private List<CreditCardEntity> creditCards;


}
