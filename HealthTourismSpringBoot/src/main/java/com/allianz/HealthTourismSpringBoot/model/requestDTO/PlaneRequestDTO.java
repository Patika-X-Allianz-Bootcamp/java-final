package com.allianz.HealthTourismSpringBoot.model.requestDTO;

import com.allianz.HealthTourismSpringBoot.util.BaseDTO;
import lombok.Data;

@Data
public class PlaneRequestDTO extends BaseDTO {

    private String model;
    private int totalSeats;
    private int availableSeats;
    private AirlineRequestDTO airline;
}
