package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.DoctorPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HealthCareServicePlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HospitalPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PatientPlainResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponseDTO extends BaseResponseDTO {
    private LocalDateTime appointmentDate;
    private PatientPlainResponseDTO patient;
    private HospitalPlainResponseDTO hospital;
    private DoctorPlainResponseDTO doctor;
    private HealthCareServicePlainResponseDTO healthService;
}
