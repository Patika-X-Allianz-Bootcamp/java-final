package com.allianz.HealthTourismSpringBoot.model.requestDTO;

import com.allianz.HealthTourismSpringBoot.util.BaseDTO;
import lombok.Data;

@Data
public class DoctorRequestDTO extends BaseDTO {

    private String name;
    private String surname;
    private String profession;
    private HospitalRequestDTO hospital;
}
