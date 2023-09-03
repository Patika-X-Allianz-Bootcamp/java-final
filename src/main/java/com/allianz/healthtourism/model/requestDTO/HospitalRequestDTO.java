package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalRequestDTO extends BaseDTO {

    private String name;

    private CityRequestDTO city;

    private List<DoctorRequestDTO> doctorList;
}