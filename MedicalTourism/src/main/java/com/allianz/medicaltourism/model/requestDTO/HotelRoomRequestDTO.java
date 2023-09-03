package com.allianz.medicaltourism.model.requestDTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class HotelRoomRequestDTO extends BaseDTO {
	private BigDecimal roomNumber;
	private BigDecimal price;
	private Boolean isAvailable;
	private PatientRequestDTO patient;
}
