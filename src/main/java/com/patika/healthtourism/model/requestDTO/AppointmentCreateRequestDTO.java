package com.patika.healthtourism.model.requestDTO;
import com.patika.healthtourism.util.BaseDTO;
import com.patika.healthtourism.util.BaseRequestDTO;
import lombok.Data;

@Data
public class AppointmentCreateRequestDTO extends BaseRequestDTO {
    private HospitalRequestDTO hospital;
    private HealthServiceRequestDTO healthService;
    private DoctorCreateRequestDTO doctor;
    private PatientRequestDTO patient;
    private Boolean confirmed;
}
