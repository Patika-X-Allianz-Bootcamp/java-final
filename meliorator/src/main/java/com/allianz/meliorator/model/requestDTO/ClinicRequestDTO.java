package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.database.entity.Doctor;
import com.allianz.meliorator.util.BaseRequestDTO;

public class ClinicRequestDTO extends BaseRequestDTO {
    private String clinicName;
    private Doctor doctor;
}
