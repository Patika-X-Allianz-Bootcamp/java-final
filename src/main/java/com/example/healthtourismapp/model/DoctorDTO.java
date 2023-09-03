package com.example.healthtourismapp.model;

import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;

@Data
public class DoctorDTO extends BaseDTO {

    private String name;
    private String surname;
    private int age;
    private String title;
}
