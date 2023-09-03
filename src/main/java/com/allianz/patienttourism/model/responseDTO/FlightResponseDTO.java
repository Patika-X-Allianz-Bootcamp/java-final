package com.allianz.patienttourism.model.responseDTO;

import com.allianz.patienttourism.database.entity.Seat;
import com.allianz.patienttourism.util.BaseResponseDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightResponseDTO extends BaseResponseDTO {

    private String company;

    private LocalDateTime flightTime;

    private String fromCity;

    private String toCity;

    private List<SeatResponseDTO> seatList;

}
