package com.allianz.medicaltourism.model.DTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO extends BaseDTO {

	private LocalDateTime appointmentDate;

	private LocalDateTime appointmentTime;

	private String doctorNotes;

	private DoctorDTO doctor;

	private PatientDTO patient;
}
