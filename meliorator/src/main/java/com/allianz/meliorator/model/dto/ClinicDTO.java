package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.database.entity.Doctor;
import com.allianz.meliorator.util.BaseDTO;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class ClinicDTO extends BaseDTO {
    private String clinicName;
    private Doctor doctor;
}
