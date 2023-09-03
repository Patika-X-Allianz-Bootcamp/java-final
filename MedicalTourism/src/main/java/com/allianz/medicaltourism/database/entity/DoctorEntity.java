package com.allianz.medicaltourism.database.entity;

import com.allianz.medicaltourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "doctor")
public class DoctorEntity extends BaseEntity {
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String Branch;
	@ManyToOne
	private HospitalEntity hospital;
	@OneToOne
	private AppointmentEntity appointment;
}
