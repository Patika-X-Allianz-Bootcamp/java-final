package com.allianz.medicaltourismapp.model;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;

import lombok.Data;

import java.util.List;

@Data
public class HospitalDTO extends BaseDTO {
    private String hospitalName;
    private String hospitalAddress;
    private String hospitalPhone;
    private List<DepartmentDTO> departmentName;
}
