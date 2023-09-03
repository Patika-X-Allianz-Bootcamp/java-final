package com.allianz.medicaltourismapp.database.entity;

import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "appointments")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "appointment_uuid"
        )
)
public class AppointmentEntity extends BaseEntity {
        @Column
        private String appointmentCode;
        @Column
        private String date;
        @Column
        private String time;
        @ManyToOne
        private DoctorEntity doctor;
        @ManyToOne
        private PatientEntity patient;

}
