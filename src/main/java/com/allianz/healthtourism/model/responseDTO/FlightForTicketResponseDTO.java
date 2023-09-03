package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PlanePlainResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FlightForTicketResponseDTO extends BaseResponseDTO {
    private BigDecimal price;
    private LocalDateTime flightDate;
    private CityResponseDTO cityTo;
    private CityResponseDTO cityFrom;
    private PlanePlainResponseDTO plane;
}
