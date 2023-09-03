package com.allianz.healthtourismagency.model.requestDTO;

import com.allianz.healthtourismagency.model.AppointmentDTO;
import com.allianz.healthtourismagency.model.enums.HospitalDepartmentEnum;
import com.allianz.healthtourismagency.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DoctorRequestDTO extends BaseDTO {

    private String name;
    private String workEmail;
    private String workPhoneNumber;
    private String identityNumber;
    private LocalDate birthDate;
    private HospitalDepartmentEnum hospitalDepartment;
    @JsonIgnore
    private List<AppointmentDTO> appointmentHistory;


}
