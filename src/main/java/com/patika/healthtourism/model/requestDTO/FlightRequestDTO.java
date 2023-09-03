package com.patika.healthtourism.model.requestDTO;

import com.patika.healthtourism.util.BaseDTO;
import com.patika.healthtourism.util.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightRequestDTO extends BaseRequestDTO {
    private String airlineName;
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private Double price;
}
