package com.allianz.healthtourismagency.model.requestDTO;

import com.allianz.healthtourismagency.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PatientRequestDTO extends BaseDTO {
    private String name;
    private String email;
    private String identityNumber;
    private LocalDate birthDate;
    @JsonIgnore
    private List<AppointmentRequestDTO> appointmentHistory;
    @JsonIgnore
    private List<MedicalReportRequestDTO> medicalReportList;

}
