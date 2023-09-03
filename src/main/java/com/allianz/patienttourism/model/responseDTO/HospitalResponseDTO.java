package com.allianz.patienttourism.model.responseDTO;

import com.allianz.patienttourism.database.entity.Doctor;
import com.allianz.patienttourism.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalResponseDTO extends BaseResponseDTO {
    String name;
    List<DoctorResponseDTO> doctorList;
}
