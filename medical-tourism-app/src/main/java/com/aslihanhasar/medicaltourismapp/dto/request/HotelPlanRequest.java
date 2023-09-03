package com.aslihanhasar.medicaltourismapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelPlanRequest {
    @NotBlank
    private Long hotelId;
    @NotBlank
    private String patientNumber;
    @NotBlank
    private int personCount;
}
