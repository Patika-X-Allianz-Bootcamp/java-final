package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExaminationRequestDTO extends BaseDTO {
    CustomerRequestDTO customer;
    DoctorRequestDTO doctor;
    LocalDateTime examinationTime;
    ExaminationCardRequestDTO examinationCard;
    HospitalRequestDTO hospital;
    MedicalDepartmentRequestDTO medicalDepartment;
}
