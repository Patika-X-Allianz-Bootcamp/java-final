package com.example.healthtourismapp.model.requestDTO;

import com.example.healthtourismapp.model.HealthServiceDTO;
import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;

@Data
public class DoctorRequestDTO extends BaseDTO {

    private String name;
    private String surname;
    private int age;
    private String title;
}
