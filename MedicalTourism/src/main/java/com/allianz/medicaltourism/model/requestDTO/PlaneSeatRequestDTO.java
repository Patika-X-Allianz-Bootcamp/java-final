package com.allianz.medicaltourism.model.requestDTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlaneSeatRequestDTO extends BaseDTO {
	private BigDecimal seatNumber;
	private PatientRequestDTO patient;
}
