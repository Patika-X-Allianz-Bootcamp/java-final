package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.DoctorPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.ExaminationRecordPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HealthCareServicePlainResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalForPatientResponseDTO extends BaseResponseDTO {
    private String name;
    private CityResponseDTO city;
    private List<DoctorForPatientResponseDTO> doctors;
    private List<HealthCareServicePlainResponseDTO> healthCareServices;
}
