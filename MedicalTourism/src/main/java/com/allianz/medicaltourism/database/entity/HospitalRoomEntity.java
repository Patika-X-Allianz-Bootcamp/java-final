package com.allianz.medicaltourism.database.entity;

import com.allianz.medicaltourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "hospital_rooms")
public class HospitalRoomEntity extends BaseEntity {
	@Column
	private BigDecimal roomNumber;
	@ManyToOne
	private HospitalEntity hospital;
	@OneToOne
	private PatientEntity patient;
}
