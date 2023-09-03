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
public class HotelSaveResponse {
    private Long hotelId;
    private String reservationNumber;
    private String hotel;
    private CitySaveResponse city;
    private int roomCount;
    private int totalCapacity;
    private BigDecimal hotelPricePerNight;

}
