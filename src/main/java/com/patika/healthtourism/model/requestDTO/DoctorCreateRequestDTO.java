package com.patika.healthtourism.model.requestDTO;

import com.patika.healthtourism.model.enums.SpecializationEnum;
import com.patika.healthtourism.util.BaseDTO;
import com.patika.healthtourism.util.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DoctorCreateRequestDTO extends BaseRequestDTO {
    private String firstName;
    private String lastName;
    private SpecializationEnum specialization;
    private LocalDateTime birthDate;
    private String phoneNumber;
    private String email;
}
