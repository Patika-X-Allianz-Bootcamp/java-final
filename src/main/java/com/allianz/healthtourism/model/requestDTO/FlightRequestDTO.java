package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseRequestDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class FlightRequestDTO extends BaseRequestDTO {
    private BigDecimal price;
    private LocalDateTime flightDate;
    private Long cityToId;
    private Long cityFromId;
    private Long planeId;
}
