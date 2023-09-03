package com.allianz.HealthTourismSpringBoot.model;

import com.allianz.HealthTourismSpringBoot.util.BaseDTO;
import lombok.Data;

@Data
public class ClientDTO extends BaseDTO {

    private String name;
    private String surname;
    private String country;
    private String healthCare;
    private AgencyDTO agency;
}
