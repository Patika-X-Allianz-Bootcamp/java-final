package com.patika.healthtourism.model;

import com.patika.healthtourism.database.entity.DoctorEntity;
import com.patika.healthtourism.database.entity.HospitalEntity;
import com.patika.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.Duration;
import java.util.Set;

@Data
public class HealthServiceDTO extends BaseDTO {
    private String serviceName;
    private String description;
    private Double price;
    private Duration duration;
    private HospitalDTO hospital;
    private Set<DoctorDTO> serviceDoctors;
}
