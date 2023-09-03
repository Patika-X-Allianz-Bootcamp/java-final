package com.allianz.medicaltourism.database.entity;

import com.allianz.medicaltourism.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "plane_seat")
public class PlaneSeatEntity extends BaseEntity {
	@Column
	private BigDecimal seatNumber;
	@OneToOne
	private PatientEntity patient;
}
