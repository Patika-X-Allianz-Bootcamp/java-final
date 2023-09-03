package com.allianz.HealthTourismSpringBoot.model.requestDTO;

import com.allianz.HealthTourismSpringBoot.util.BaseDTO;
import lombok.Data;

import java.util.Date;

@Data
public class ExaminationRequestDTO extends BaseDTO {

    private String medicalTreatment;
    private Date examinationDate;
    private ClientRequestDTO client;
    private DoctorRequestDTO doctor;
}
