package com.allianz.medicaltourism.database.entity;

import com.allianz.medicaltourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "hospital")
public class HospitalEntity extends BaseEntity {
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String phone;
	@Column
	private String email;

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.REFRESH}, mappedBy = "hospital")
	private List<HospitalRoomEntity> hospitalRooms;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hospital", cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
	private List<DoctorEntity> doctors;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hospital", cascade = CascadeType.ALL)
	private List<DepartmentEntity> departments;


}
