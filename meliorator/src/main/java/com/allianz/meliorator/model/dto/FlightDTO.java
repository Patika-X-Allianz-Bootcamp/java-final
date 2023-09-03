package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.database.entity.City;
import com.allianz.meliorator.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
public class FlightDTO extends BaseDTO {

    private String CompanyName;
    private City departureFrom;

    private City arrivalTo;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private String flightNumber;

    private Time flightDuration;
}
