package com.allianz.healthtourismagency.model.requestDTO;

import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalRequestDTO extends BaseDTO {

    private String name;
    private List<DoctorRequestDTO> doctorList;


}
