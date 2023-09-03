package com.allianz.patienttourism.model.requestDTO;

import com.allianz.patienttourism.util.BaseRequestDTO;
import lombok.Data;

@Data
public class DoctorRequestDTO extends BaseRequestDTO {


    String name;

    String surname;

    int age;

    String department;

    Long hospitalId;
}
