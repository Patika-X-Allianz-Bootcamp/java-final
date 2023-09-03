package com.aslihanhasar.medicaltourismapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalSaveResponse {
    private Long hospitalId;
    private String hospital;
    private String cityName;
    private String countryName;
}
