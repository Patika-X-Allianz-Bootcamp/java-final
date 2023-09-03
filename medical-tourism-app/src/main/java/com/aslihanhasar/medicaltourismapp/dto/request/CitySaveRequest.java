package com.aslihanhasar.medicaltourismapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitySaveRequest {
    private String cityName;
    private Long countryId;
}
