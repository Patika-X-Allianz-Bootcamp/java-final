package com.aslihanhasar.medicaltourismapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "doctors")
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "doctor_id"
        )
)
public class Doctor extends BaseEntity {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "specialization_id", nullable = false)
    private DoctorSpecialization specialization;
    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}
