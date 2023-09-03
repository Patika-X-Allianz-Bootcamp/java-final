package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ExaminationResponseDTO extends BaseDTO {
    private CustomerResponseDTO customer;
    private DoctorResponseDTO doctor;
    private LocalDateTime examinationTime;
    private ExaminationCardResponseDTO examinationCard;
    private HospitalResponseDTO hospital;
    private MedicalDepartmentResponseDTO medicalDepartment;
    private UUID travelPlanUuid;
}
