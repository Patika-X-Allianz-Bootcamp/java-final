package com.allianz.HealthTourismSpringBoot.model;

import com.allianz.HealthTourismSpringBoot.util.BaseDTO;
import lombok.Data;

@Data
public class DoctorDTO extends BaseDTO {

    private String name;
    private String surname;
    private String profession;
    private HospitalDTO hospital;
}
