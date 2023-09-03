package com.allianz.HealthTourismSpringBoot.model.requestDTO;

import com.allianz.HealthTourismSpringBoot.util.BaseDTO;
import lombok.Data;

@Data
public class AirlineRequestDTO extends BaseDTO {

    private String name;
    private AgencyRequestDTO agency;
}
