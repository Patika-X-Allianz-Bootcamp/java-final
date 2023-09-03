package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class DoctorResponseDTO extends BaseDTO {
    String name;
    String surname;
    String governmentID;
    Set<HospitalResponseDTO> hospitalList = new HashSet<>();
    Set<MedicalDepartmentResponseDTO> medicalDepartmentSet = new HashSet<>();
    List<SalaryResponseDTO> salaryList = new ArrayList<>();
    List<String> workHourList = new ArrayList<>();
}
