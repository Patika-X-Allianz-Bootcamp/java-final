package com.aslihanhasar.medicaltourismapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportSaveResponse {
    private Long airportId;
    private String airport;
    private CitySaveResponse airportLocation;
}
