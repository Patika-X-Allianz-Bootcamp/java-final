package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.AppointmentPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HospitalPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.UserPlainResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import com.allianz.healthtourism.util.security.UserResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class DoctorForPatientWithAppointmentResponseDTO extends PersonResponseDTO {
    private UserPlainResponseDTO user;
    private HealthCareServiceResponseDTO healthCareService;
    private List<AppointmentPlainResponseDTO> appointments;
}
