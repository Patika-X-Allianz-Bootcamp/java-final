package com.allianz.medicaltourism.model.DTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlaneSeatDTO extends BaseDTO {
	private BigDecimal seatNumber;
	private PatientDTO patient;
}
