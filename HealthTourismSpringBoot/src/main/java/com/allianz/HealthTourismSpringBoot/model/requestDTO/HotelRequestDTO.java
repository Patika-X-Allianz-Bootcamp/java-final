package com.allianz.HealthTourismSpringBoot.model.requestDTO;

import com.allianz.HealthTourismSpringBoot.util.BaseDTO;
import lombok.Data;

@Data
public class HotelRequestDTO extends BaseDTO {

    private String name;
    private int totalRooms;
    private int availableRooms;
    private AgencyRequestDTO agency;
}
