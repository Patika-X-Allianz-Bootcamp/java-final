package com.allianz.patienttourism.model.requestDTO;

import com.allianz.patienttourism.util.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequestDTO extends BaseRequestDTO {

    private Long patientId;

    private Long doctorId;

    private LocalDateTime appointmentTime;
}
