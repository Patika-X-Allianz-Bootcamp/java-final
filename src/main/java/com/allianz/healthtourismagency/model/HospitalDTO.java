package com.allianz.healthtourismagency.model;

import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalDTO extends BaseDTO {

    private String name;
    private List<DoctorDTO> doctorList;


}
