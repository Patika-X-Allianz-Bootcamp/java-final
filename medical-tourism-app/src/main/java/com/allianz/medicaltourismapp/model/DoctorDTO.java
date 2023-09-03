package com.allianz.medicaltourismapp.model;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class DoctorDTO extends PersonDTO {

    private List<AppointmentDTO> appointmentCodes;
    private DepartmentDTO departmentName;



}
