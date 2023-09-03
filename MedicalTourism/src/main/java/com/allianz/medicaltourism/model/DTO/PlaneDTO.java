package com.allianz.medicaltourism.model.DTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PlaneDTO extends BaseDTO {
	private Date departureDate;
	private List<PlaneSeatDTO> planeSeat;
	private String departureCity;
	private String arrivalCity;
}
