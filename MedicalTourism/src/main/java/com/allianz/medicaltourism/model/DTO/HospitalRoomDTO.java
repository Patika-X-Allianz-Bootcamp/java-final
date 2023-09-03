package com.allianz.medicaltourism.model.DTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class HospitalRoomDTO extends BaseDTO {
	private BigDecimal roomNumber;
	private PatientDTO patient;
}
