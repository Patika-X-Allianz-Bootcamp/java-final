package com.example.healthtourismapp.model.requestDTO;

import com.example.healthtourismapp.model.DoctorDTO;
import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;
import java.util.List;

@Data
public class HealthServiceRequestDTO extends BaseDTO {

    private String serviceName;
    private List<DoctorDTO> doctorList;
}
