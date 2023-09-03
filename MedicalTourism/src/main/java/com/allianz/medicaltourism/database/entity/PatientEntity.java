package com.allianz.medicaltourism.database.entity;

import com.allianz.medicaltourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patient")
public class PatientEntity extends BaseEntity {
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String address;
	@OneToOne
	private HospitalRoomEntity hospitalRoom;
	@OneToOne
	private FlightScheduleEntity flightSchedule;
	@OneToOne
	private AppointmentEntity appointment;
}
