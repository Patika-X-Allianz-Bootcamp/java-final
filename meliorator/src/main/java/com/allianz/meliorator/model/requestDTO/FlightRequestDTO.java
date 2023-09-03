package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.database.entity.City;
import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
public class FlightRequestDTO extends BaseRequestDTO {
    private String CompanyName;
    private City departureFrom;
    private City arrivalTo;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String flightNumber;
    private Time flightDuration;
}
