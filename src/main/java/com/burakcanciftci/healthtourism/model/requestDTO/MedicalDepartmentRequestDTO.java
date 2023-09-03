package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

@Data
public class MedicalDepartmentRequestDTO extends BaseDTO {
    String speciality;
    HospitalRequestDTO hospital;
}
