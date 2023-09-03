package com.aslihanhasar.medicaltourismapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "medical_records")
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "medical_record_id"
        )
)
public class MedicalRecord extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;
    @Lob
    @Column(nullable = false)
    private String examinationNotes;
}
