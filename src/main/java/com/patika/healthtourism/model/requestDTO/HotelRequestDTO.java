package com.patika.healthtourism.model.requestDTO;

import com.patika.healthtourism.util.BaseDTO;
import com.patika.healthtourism.util.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class HotelRequestDTO extends BaseRequestDTO {
    private String name;
    private String address;
    private String phoneNumber;
    private Double pricePerNight;
    private Integer starRating;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
