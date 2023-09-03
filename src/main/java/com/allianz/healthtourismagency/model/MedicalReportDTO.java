package com.allianz.healthtourismagency.model;

import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class MedicalReportDTO extends BaseDTO {

    public String diagnosis;
    public String treatment;
    public List<MedicationDTO> medicationList;
    public List<TestResultDTO> testResultList;

}
