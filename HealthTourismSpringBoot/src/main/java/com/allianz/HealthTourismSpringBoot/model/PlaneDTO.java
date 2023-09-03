package com.allianz.HealthTourismSpringBoot.model;

import com.allianz.HealthTourismSpringBoot.util.BaseDTO;
import lombok.Data;

@Data
public class PlaneDTO extends BaseDTO {

    private String model;
    private int totalSeats;
    private int availableSeats;
    private AirlineDTO airline;
}
