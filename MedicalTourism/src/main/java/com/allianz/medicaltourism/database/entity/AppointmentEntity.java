package com.allianz.medicaltourism.database.entity;

import com.allianz.medicaltourism.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "appointment")
public class AppointmentEntity extends BaseEntity {
	@Column
	private LocalDateTime appointmentDate;
	@Column
	private LocalDateTime appointmentTime;
	@Column
	private String doctorNotes;
	@OneToOne
	private DoctorEntity doctor;
	@OneToOne
	private PatientEntity patient;
}
