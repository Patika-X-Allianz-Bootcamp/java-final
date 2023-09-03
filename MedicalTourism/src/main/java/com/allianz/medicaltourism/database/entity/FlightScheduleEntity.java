package com.allianz.medicaltourism.database.entity;

import com.allianz.medicaltourism.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "flight_schedule")
public class FlightScheduleEntity extends BaseEntity {
	@Column
	private String flightNumber;
	@Column
	private LocalDateTime departureDate;
	@Column
	private LocalDateTime arrivalDate;
	@OneToOne
	private PatientEntity patient;
}
