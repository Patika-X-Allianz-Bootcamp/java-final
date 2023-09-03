package com.healthtourism.healthtourism.model;

import com.healthtourism.healthtourism.database.entities.AppointmentEntity;
import com.healthtourism.healthtourism.database.entities.FlightInfoEntity;
import com.healthtourism.healthtourism.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PatientDTO extends BaseDTO {

    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String phoneNumber;




}
