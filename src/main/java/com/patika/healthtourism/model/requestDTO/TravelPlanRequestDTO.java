package com.patika.healthtourism.model.requestDTO;

import com.patika.healthtourism.util.BaseDTO;
import com.patika.healthtourism.util.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TravelPlanRequestDTO extends BaseRequestDTO {
    private PatientRequestDTO patient;
    private FlightRequestDTO flight;
    private HotelRequestDTO hotel;
    private LocalDateTime reservationDateTime;
    private Boolean confirmed;
    private Double price;
}
