package com.aslihanhasar.medicaltourismapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalRecordResponse {
    private Long medicalRecordId;
    private Long appointmentId;
    private String examinationNotes;
}
