package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.DoctorPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.ExaminationRecordPlainResponseDTO;
import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.PatientPlainResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalResponseDTO extends BaseResponseDTO {
    private String name;
    private CityResponseDTO city;
    private List<ExaminationRecordPlainResponseDTO> examinationRecords;
    private List<PatientWithExaminationRecordResponseDTO> patients;
    private List<DoctorPlainResponseDTO> doctors;
    private List<HealthCareServiceResponseDTO> healthCareServices;
}
