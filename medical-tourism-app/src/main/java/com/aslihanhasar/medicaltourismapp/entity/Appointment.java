package com.aslihanhasar.medicaltourismapp.entity;

import com.aslihanhasar.medicaltourismapp.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "appointments")
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "appointment_id"
        )
)
public class Appointment extends BaseEntity {
    @Column(unique = true)
    private String appointmentNumber;
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
    @Column(nullable = false)
    private LocalDate appointmentDate;
    @Column(nullable = false)
    private LocalTime appointmentTime;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus;
}
