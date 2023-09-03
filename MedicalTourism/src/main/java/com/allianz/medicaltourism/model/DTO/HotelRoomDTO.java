package com.allianz.medicaltourism.model.DTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class HotelRoomDTO extends BaseDTO {
	private BigDecimal roomNumber;
	private BigDecimal price;
	private Boolean isAvailable;
	private PatientDTO patient;
}
