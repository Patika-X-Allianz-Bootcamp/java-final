package com.aslihanhasar.medicaltourismapp.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelSaveRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String hotelCode;
    @NotBlank
    private Long cityId;
    @NotBlank
    private int roomCount;
    @NotBlank
    @Min(20)
    private int totalCapacity;
    @NotBlank
    private BigDecimal hotelPricePerNight;
}
