package com.healthtourism.healthtourism.model.RequestDTO;

import com.healthtourism.healthtourism.model.FlightInfoDTO;
import com.healthtourism.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PatientRequestDTO extends BaseDTO {
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String phoneNumber;


}
