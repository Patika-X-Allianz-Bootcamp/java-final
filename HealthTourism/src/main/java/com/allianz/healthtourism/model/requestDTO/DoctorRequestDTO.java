package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class DoctorRequestDTO extends BaseDTO {


    private String name;
    private String phoneNumber;

    private HealthCareRequestDTO healthCare;

    private HospitalRequestDTO hospital;

    private List<PatientRequestDTO> patientEntityList;

    private List<AppointmentRequestDTO> appointmentList;
}
