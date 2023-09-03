package com.allianz.medicaltourism.model.requestDTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class HospitalRoomRequestDTO extends BaseDTO {
	private BigDecimal roomNumber;
	private PatientRequestDTO patient;
}
