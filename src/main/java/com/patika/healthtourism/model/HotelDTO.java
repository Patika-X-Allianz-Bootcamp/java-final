package com.patika.healthtourism.model;

import com.patika.healthtourism.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class HotelDTO extends BaseDTO {
    private String name;
    private String address;
    private String phoneNumber;
    private Double pricePerNight;
    private Integer starRating;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
