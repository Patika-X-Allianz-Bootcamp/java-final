package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PatientPlainResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentWithPatientResponseDTO extends BaseResponseDTO {
    private LocalDateTime appointmentDate;
    private PatientPlainResponseDTO patient;
}
