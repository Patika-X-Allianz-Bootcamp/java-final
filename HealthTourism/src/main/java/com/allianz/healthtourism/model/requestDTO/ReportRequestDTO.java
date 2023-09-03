package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.model.DTO.DoctorDTO;
import com.allianz.healthtourism.model.DTO.PatientDTO;
import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

@Data
public class ReportRequestDTO extends BaseDTO {
    private PatientDTO patient;
    private DoctorDTO doctor;
    private String detail;
}
