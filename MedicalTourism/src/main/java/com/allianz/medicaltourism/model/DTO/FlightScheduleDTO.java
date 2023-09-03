package com.allianz.medicaltourism.model.DTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightScheduleDTO extends BaseDTO {
	private String flightNumber;
	private LocalDateTime departureDate;
	private LocalDateTime arrivalDate;
	private PatientDTO patient;
}
