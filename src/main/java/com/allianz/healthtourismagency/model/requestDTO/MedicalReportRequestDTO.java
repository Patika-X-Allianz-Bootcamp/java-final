package com.allianz.healthtourismagency.model.requestDTO;

import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class MedicalReportRequestDTO extends BaseDTO {

    public String diagnosis;
    public String treatment;
    public List<MedicationRequestDTO> medicationList;
    public List<TestResultRequestDTO> testResultList;

}
