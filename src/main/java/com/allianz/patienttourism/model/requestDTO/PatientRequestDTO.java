package com.allianz.patienttourism.model.requestDTO;

import com.allianz.patienttourism.util.BaseRequestDTO;
import lombok.Data;

@Data
public class PatientRequestDTO extends BaseRequestDTO {

    private String name;

    private String surname;

    private int age;

}
