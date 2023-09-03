package com.allianz.healthtourismagency.model;

import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PatientDTO extends BaseDTO {
    private String name;
    private String email;
    private String identityNumber;
    private LocalDate birthDate;
    private List<AppointmentDTO> appointmentHistory;
    private List<MedicalReportDTO> medicalReportList;

}
