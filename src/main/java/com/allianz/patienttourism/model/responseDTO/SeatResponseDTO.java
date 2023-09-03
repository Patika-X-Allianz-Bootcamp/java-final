package com.allianz.patienttourism.model.responseDTO;

import com.allianz.patienttourism.model.enums.SeatType;
import com.allianz.patienttourism.util.BaseResponseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SeatResponseDTO extends BaseResponseDTO {

    private String seatNumber;

    private SeatType seatType;

    private BigDecimal price;

    private Long flightId;

    private List<TicketResponseDTO> ticketList;


}
