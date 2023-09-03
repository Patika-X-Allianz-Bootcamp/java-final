package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class HospitalResponseDTO extends BaseDTO {
    String name;
    AddressResponseDTO address;
    Set<BankAccountResponseDTO> bankAccountSet = new HashSet<>();
    Set<MedicalDepartmentResponseDTO> departmentSet = new HashSet<>();
    List<DoctorResponseDTO> doctorList = new ArrayList<>();
}
