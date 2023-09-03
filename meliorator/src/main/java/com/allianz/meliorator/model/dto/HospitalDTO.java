package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.database.entity.Clinic;
import com.allianz.meliorator.util.BaseDTO;
import com.allianz.meliorator.util.BaseRequestDTO;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class HospitalDTO extends BaseDTO {
    private String name;
    private List<Clinic> clinic;
}
