package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.model.requestDTO.HospitalRequestDTO;
import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

@Data
public class MedicalDepartmentResponseDTO extends BaseDTO {
    String speciality;
    HospitalResponseDTO hospital;
}
