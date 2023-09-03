package com.allianz.medicaltourism.database.entity;

import com.allianz.medicaltourism.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "hotel")
public class HotelEntity extends BaseEntity {
	@Column
	private String name;
	@Column
	private String address;
	@OneToMany
	private List<HotelRoomEntity> hotelRooms;
}
