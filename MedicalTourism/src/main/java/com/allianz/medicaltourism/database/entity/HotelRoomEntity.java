package com.allianz.medicaltourism.database.entity;

import com.allianz.medicaltourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "hotel_room")
public class HotelRoomEntity extends BaseEntity {
	@Column
	private BigDecimal roomNumber;
	@Column
	private BigDecimal price;
	@Column
	private Boolean isAvailable;
	@OneToOne
	private PatientEntity patient;
	@ManyToOne
	private HotelEntity hotel;
}
