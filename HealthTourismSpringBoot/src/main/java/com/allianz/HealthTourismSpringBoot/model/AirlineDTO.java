package com.allianz.HealthTourismSpringBoot.model;

import com.allianz.HealthTourismSpringBoot.util.BaseDTO;
import lombok.Data;

@Data
public class AirlineDTO extends BaseDTO {

    private String name;
    private AgencyDTO agency;
}
