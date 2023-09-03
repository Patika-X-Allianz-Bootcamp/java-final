package com.allianz.medicaltourism.database.entity;

import com.allianz.medicaltourism.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "department")
public class DepartmentEntity extends BaseEntity {
	@Column
	private String name;
	@Column
	private String description;
	@ManyToOne
	private HospitalEntity hospital;
}
