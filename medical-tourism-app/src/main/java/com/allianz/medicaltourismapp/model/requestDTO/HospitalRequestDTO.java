package com.allianz.medicaltourismapp.model.requestDTO;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalRequestDTO extends BaseDTO {
    private String hospitalName;
    private String hospitalAddress;
    private String hospitalPhone;
    private List<DepartmentRequestDTO> departments;
}
