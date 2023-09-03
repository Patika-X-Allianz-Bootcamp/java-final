package com.allianz.patienttourism.model.requestDTO;

import com.allianz.patienttourism.util.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightRequestDTO extends BaseRequestDTO {

    private String company;

    private LocalDateTime flightTime;

    private String fromCity;

    private String toCity;

}
