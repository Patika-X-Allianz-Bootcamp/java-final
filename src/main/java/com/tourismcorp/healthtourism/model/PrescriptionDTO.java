package com.tourismcorp.healthtourism.model;

import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

@Data
public class PrescriptionDTO extends BaseDTO {

    private DoctorDTO doctor;

    private String prescription;

}
