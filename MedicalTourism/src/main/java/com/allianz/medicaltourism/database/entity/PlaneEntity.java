package com.allianz.medicaltourism.database.entity;

import com.allianz.medicaltourism.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "plane")
public class PlaneEntity extends BaseEntity {
	@Column
	private Date departureDate;
	@OneToMany
	private List<PlaneSeatEntity> planeSeat;
	@Column
	private String departureCity;
	@Column
	private String arrivalCity;
}
