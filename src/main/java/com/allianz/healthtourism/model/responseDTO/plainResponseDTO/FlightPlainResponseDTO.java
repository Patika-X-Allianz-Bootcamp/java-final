package com.allianz.healthtourism.model.responseDTO.plainResponseDTO;

import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightPlainResponseDTO extends BaseResponseDTO {
    private BigDecimal price;
    private LocalDateTime flightDate;
}
