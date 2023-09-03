package com.allianz.HealthTourismSpringBoot.model;

import com.allianz.HealthTourismSpringBoot.util.BaseDTO;
import lombok.Data;

@Data
public class HotelDTO extends BaseDTO {

    private String name;
    private int totalRooms;
    private int availableRooms;
    private AgencyDTO agency;
}
