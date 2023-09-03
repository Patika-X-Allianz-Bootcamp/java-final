package com.aslihanhasar.medicaltourismapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitySaveResponse {
    private Long cityId;
    private String cityName;
    private String countryName;
}
