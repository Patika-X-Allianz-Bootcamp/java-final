package com.allianz.healthtourism.model;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightDTO extends BaseDTO {
    private String flightNo;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String departureLocation;
    private String arrivalLocation;
    private int capacity;
}