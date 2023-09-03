package com.allianz.HealthTourismSpringBoot.model;

import com.allianz.HealthTourismSpringBoot.util.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class ExaminationDTO extends BaseDTO {

    private String medicalTreatment;
    private Date examinationDate;
    private ClientDTO client;
    private DoctorDTO doctor;
}
