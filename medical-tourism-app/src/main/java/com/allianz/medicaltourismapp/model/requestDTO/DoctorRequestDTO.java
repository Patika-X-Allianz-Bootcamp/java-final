package com.allianz.medicaltourismapp.model.requestDTO;

import com.allianz.medicaltourismapp.database.entity.RoleEntity;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class DoctorRequestDTO extends PersonRequestDTO {
    private Set<RoleEntity> roles;
    private boolean isEnable;
    private List<AppointmentRequestDTO> appointments;
    private DepartmentRequestDTO department;

    public DoctorRequestDTO() {
        isEnable = false;
    }

}
