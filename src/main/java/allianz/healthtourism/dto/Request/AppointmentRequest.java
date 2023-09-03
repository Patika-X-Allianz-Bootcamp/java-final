package allianz.healthtourism.dto.Request;

import allianz.healthtourism.base.BaseRequestDTO;
import allianz.healthtourism.dto.Response.DoctorDTO;
import allianz.healthtourism.dto.Response.HealthServiceDTO;
import allianz.healthtourism.dto.Response.PatientDTO;
import allianz.healthtourism.entity.Doctor;
import allianz.healthtourism.entity.HealthService;
import allianz.healthtourism.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequest extends BaseRequestDTO {

    private Long patientId;

    private Long doctorId;

    private Long healthServiceId;

    private LocalDateTime appointmentDateTime;

    private boolean isConfirmed;  // Randevu onay durumu

    private boolean isInvalid;

    @JsonIgnore
    private LocalDateTime createdAt = LocalDateTime.now();

}
