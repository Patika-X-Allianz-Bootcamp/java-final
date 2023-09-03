package com.allianz.healthtourism.model.DTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalDTO extends BaseDTO {
    private String name;
    private String city;
    private List<DoctorDTO> doctors;
    private List<PatientDTO> patients;


}