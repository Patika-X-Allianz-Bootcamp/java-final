package com.tourismcorp.healthtourism.model.requestDTO;

import com.tourismcorp.healthtourism.model.DoctorDTO;
import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

@Data
public class PrescriptionRequestDTO extends BaseDTO {

    private DoctorRequestDTO doctor;

    private String prescription;

}
