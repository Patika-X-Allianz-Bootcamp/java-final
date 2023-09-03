package com.allianz.healthtourism.model.responseDTO.plainResponseDTO;

import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentPlainResponseDTO extends BaseResponseDTO {
    private LocalDateTime appointmentDate;
}
