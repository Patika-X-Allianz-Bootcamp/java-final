package com.patika.healthtourism.model.requestDTO;

import com.patika.healthtourism.util.BaseDTO;
import com.patika.healthtourism.util.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequestDTO extends BaseRequestDTO {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;
}
