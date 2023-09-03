package com.allianz.patienttourism.model.requestDTO;

import com.allianz.patienttourism.model.enums.SeatType;
import com.allianz.patienttourism.util.BaseRequestDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SeatRequestDTO extends BaseRequestDTO {

    private String seatNumber;

    private SeatType seatType;

    private BigDecimal price;

    private Long flightId;
}
