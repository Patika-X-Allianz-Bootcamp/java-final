package com.allianz.HealthTourismSpringBoot.model.requestDTO;

import com.allianz.HealthTourismSpringBoot.util.BaseDTO;
import lombok.Data;

@Data
public class ClientRequestDTO extends BaseDTO {

    private String name;
    private String surname;
    private String country;
    private String healthCare;
    private AgencyRequestDTO agency;
}
