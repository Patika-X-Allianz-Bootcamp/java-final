package com.allianz.medicaltourismapp.database.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "doctors")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "doctor_uuid"
        )
)
public class DoctorEntity extends PersonEntity {


    @OneToMany
    private List<AppointmentEntity> appointments;

    @ManyToOne
    private DepartmentEntity department;

}
