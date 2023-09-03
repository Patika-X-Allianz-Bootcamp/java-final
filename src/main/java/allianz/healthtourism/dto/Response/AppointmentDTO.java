package allianz.healthtourism.dto.Response;

import allianz.healthtourism.base.BaseDTO;
import allianz.healthtourism.entity.Doctor;
import allianz.healthtourism.entity.HealthService;
import allianz.healthtourism.entity.Patient;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO extends BaseDTO {

    private Long patientId;

    private Long doctorId;

    private Long healthServiceId;

    private LocalDateTime appointmentDateTime;

    private boolean isConfirmed;

    private boolean isInvalid;

    private LocalDateTime createdAt = LocalDateTime.now();

}
