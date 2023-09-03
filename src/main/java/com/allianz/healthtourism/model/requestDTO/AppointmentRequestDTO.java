package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequestDTO extends BaseRequestDTO {
    private LocalDateTime appointmentDate;
    private Long patientId;
    private Long doctorId;
    private Long healthServiceId;
    private Long hospitalId;
}
