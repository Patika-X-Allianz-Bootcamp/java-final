package com.hospitalsystem.hospitalsystem.model.requestDTO;

import com.hospitalsystem.hospitalsystem.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightRequestDTO extends BaseDTO {

    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String destinationAirport;
    private String origin;
}
