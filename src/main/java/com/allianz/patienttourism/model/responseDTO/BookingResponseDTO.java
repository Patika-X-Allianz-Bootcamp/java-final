package com.allianz.patienttourism.model.responseDTO;

import com.allianz.patienttourism.util.BaseResponseDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingResponseDTO extends BaseResponseDTO {

    private Long roomId;

    private Long patientId;

    private LocalDate bookingDate;
}
