package com.allianz.medicaltourismapp.model.requestDTO;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;

import java.util.List;
@Data
public class DepartmentRequestDTO extends BaseDTO {
    private List<DoctorRequestDTO> doctor;
    private String departmentName;
}
