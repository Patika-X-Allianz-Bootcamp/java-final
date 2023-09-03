package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.util.BaseDTO;
import lombok.Data;

@Data
public class PatientDTO extends BaseDTO {
    private String name;
    private String surname;
}
