package com.demo.medicaltourismapp.model.requestDTO;

import com.demo.medicaltourismapp.model.AppointmentDTO;
import com.demo.medicaltourismapp.model.HospitalDTO;
import com.demo.medicaltourismapp.model.enums.DoctorSpecialtyEnum;
import com.demo.medicaltourismapp.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class DoctorRequestDTO extends BaseDTO {

    private HospitalDTO hospital;
    private DoctorSpecialtyEnum doctorSpecialtyEnum;
    @JsonIgnore
    private List<AppointmentDTO> appointmentList;
}
