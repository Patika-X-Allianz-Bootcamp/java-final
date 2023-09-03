package com.allianz.medicaltourism.model.requestDTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequestDTO extends BaseDTO {

	private LocalDateTime appointmentDate;

	private LocalDateTime appointmentTime;

	private String doctorNotes;

	private DoctorRequestDTO doctor;

	private PatientRequestDTO patient;
}
