package com.allianz.healthtourismagency.model;

import com.allianz.healthtourismagency.model.enums.HospitalDepartmentEnum;
import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DoctorDTO extends BaseDTO {

    private String name;
    private String workEmail;
    private String workPhoneNumber;
    private String identityNumber;
    private LocalDate birthDate;
    private HospitalDepartmentEnum hospitalDepartment;
    private List<AppointmentDTO> appointmentHistory;


}
