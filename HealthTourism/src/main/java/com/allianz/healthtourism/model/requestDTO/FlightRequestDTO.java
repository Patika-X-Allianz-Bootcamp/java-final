package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightRequestDTO extends BaseDTO {

    private String airline;

    private LocalDateTime fligthTime;

    private String flightNumber;

    private CityRequestDTO departureCity;

    private CityRequestDTO destinationCity;

    private List<PatientRequestDTO> patientList;
}
