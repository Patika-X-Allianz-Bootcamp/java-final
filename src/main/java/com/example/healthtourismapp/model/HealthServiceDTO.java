package com.example.healthtourismapp.model;

import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;
import java.util.List;

@Data
public class HealthServiceDTO extends BaseDTO {

    private String serviceName;
    private List<DoctorDTO> doctorList;
}
