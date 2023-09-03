package com.allianz.medicaltourism.model.requestDTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightScheduleRequestDTO extends BaseDTO {
	private String flightNumber;
	private LocalDateTime departureDate;
	private LocalDateTime arrivalDate;
	private PatientRequestDTO patient;
}
