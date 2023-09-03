package com.allianz.patienttourism.model.requestDTO;

import com.allianz.patienttourism.util.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequestDTO extends BaseRequestDTO {

    private Long roomId;

    private Long patientId;

    private LocalDate bookingDate;
}
