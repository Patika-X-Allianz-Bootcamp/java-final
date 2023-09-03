package com.allianz.medicaltourismapp.model;
import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;
import java.util.List;
@Data
public class DepartmentDTO extends BaseDTO {
    private List<DoctorDTO> doctors;
    private String departmentName;
}
