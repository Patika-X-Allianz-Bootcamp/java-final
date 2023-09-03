package com.healthtourism.healthtourism.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.healthtourism.healthtourism.database.entities.PatientEntity;
import com.healthtourism.healthtourism.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightInfoDTO extends BaseDTO {
    private String airlineCompany;
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime arrivalDateTime;
    private String reservationStatus;
    private boolean confirmed;
    private LocalDateTime departureDateTime; // Uçağın kalkış zamanı
    private LocalDateTime currentDateTime;   // Anlık zaman
    private List<PatientDTO> patients;


}
