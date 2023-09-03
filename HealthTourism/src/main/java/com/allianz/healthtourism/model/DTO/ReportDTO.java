package com.allianz.healthtourism.model.DTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

@Data
public class ReportDTO extends BaseDTO {
    private PatientDTO patient;
    private DoctorDTO doctor;
    private String detail;
}
