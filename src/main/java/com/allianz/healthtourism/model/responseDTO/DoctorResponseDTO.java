package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HospitalPlainResponseDTO;
import com.allianz.healthtourism.util.BaseRequestDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import com.allianz.healthtourism.util.security.UserEntity;
import com.allianz.healthtourism.util.security.UserResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class DoctorResponseDTO extends PersonResponseDTO {
    private HospitalPlainResponseDTO hospital;
    private HealthCareServiceResponseDTO healthCareService;
    private List<ExaminationRecordResponseDTO> examinationRecords;
    private UserResponseDTO user;
    private List<AppointmentWithPatientResponseDTO> appointments;
}
