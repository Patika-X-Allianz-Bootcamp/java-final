package com.allianz.medicaltourism.model.requestDTO;

import com.allianz.medicaltourism.util.BaseDTO;
import lombok.Data;
import org.w3c.dom.ls.LSInput;

import java.util.Date;
import java.util.List;

@Data
public class PlaneRequestDTO extends BaseDTO {
	private Date departureDate;
	private List<PlaneSeatRequestDTO> planeSeat;
	private String departureCity;
	private String arrivalCity;
}
