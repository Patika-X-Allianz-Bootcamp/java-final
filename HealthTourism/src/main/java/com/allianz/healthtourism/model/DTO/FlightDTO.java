package com.allianz.healthtourism.model.DTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightDTO extends BaseDTO {

    private String airline;

    private LocalDateTime fligthTime;

    private String flightNumber;

    private CityDTO departureCity;

    private CityDTO destinationCity;

    private List<PatientDTO> patientList;
}
