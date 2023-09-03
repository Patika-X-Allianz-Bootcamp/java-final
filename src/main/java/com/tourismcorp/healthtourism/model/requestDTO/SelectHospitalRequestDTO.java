package com.tourismcorp.healthtourism.model.requestDTO;

import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

@Data
public class SelectHospitalRequestDTO extends BaseDTO {
    private HospitalRequestDTO hospital;
}
