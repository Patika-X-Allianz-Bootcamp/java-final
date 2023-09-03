package com.allianz.healthtourism.model.DTO;

import com.allianz.healthtourism.util.BaseDTO;
import com.allianz.healthtourism.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class DoctorDTO extends BaseDTO {


    private String name;
    private String phoneNumber;

    private HealthCareDTO healthCare;

    private HospitalDTO hospital;

    private List<PatientDTO> patientEntityList;

    private List<AppointmentDTO> appointmentList;
}
