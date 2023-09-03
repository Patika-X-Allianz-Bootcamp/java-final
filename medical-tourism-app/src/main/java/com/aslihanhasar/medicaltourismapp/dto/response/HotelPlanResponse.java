package com.aslihanhasar.medicaltourismapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelPlanResponse {
    private String reservationNumber;
    private PatientSaveResponse patient;
    private Long hotelId;
    private String hotel;
    private CitySaveResponse city;
}
