package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class DoctorRequestDTO extends BaseDTO {
    String name;
    String surname;
    String governmentID;
    Set<HospitalRequestDTO> hospitalList = new HashSet<>();
    Set<MedicalDepartmentRequestDTO> medicalDepartmentSet = new HashSet<>();
    List<SalaryRequestDTO> salaryList = new ArrayList<>();
    List<String> workHourList = new ArrayList<>();
}
