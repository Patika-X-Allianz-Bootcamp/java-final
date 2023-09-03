package com.patika.healthtourism.model;

import com.patika.healthtourism.database.entity.ExaminationEntity;
import com.patika.healthtourism.database.entity.HealthServiceEntity;
import com.patika.healthtourism.model.enums.SpecializationEnum;
import com.patika.healthtourism.util.BaseDTO;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class DoctorDTO extends BaseDTO {
    private String firstName;
    private String lastName;
    private SpecializationEnum specialization;
    private LocalDateTime birthDate;
    private String phoneNumber;
    private String email;
}
