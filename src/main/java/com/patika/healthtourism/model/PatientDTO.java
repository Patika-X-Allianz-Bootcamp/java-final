package com.patika.healthtourism.model;

import com.patika.healthtourism.database.entity.AppointmentEntity;
import com.patika.healthtourism.database.entity.ExaminationEntity;
import com.patika.healthtourism.database.entity.TravelPlanEntity;
import com.patika.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class PatientDTO extends BaseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;
    private Set<AppointmentDTO> appointments;
}
