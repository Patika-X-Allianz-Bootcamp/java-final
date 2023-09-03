package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PatientPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PlanePlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.SeatPlainResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightForPatientResponseDTO extends BaseResponseDTO {
    private BigDecimal price;
    private LocalDateTime flightDate;
    private CityResponseDTO cityTo;
    private CityResponseDTO cityFrom;
    private PlanePlainResponseDTO plane;
    private List<SeatPlainResponseDTO> seats;
}
