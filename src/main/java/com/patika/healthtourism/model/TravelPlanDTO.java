package com.patika.healthtourism.model;

import com.patika.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TravelPlanDTO extends BaseDTO {
    private PatientDTO patient;
    private FlightDTO flight;
    private HotelDTO hotel;
    private LocalDateTime reservationDateTime;
    private Boolean confirmed;
    private Double price;
}
