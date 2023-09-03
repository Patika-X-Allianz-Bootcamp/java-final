package com.allianz.patienttourism.model.responseDTO;

import com.allianz.patienttourism.util.BaseResponseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketResponseDTO extends BaseResponseDTO {

    private Long patientId;

    private Long seatId;

    private LocalDateTime ticketTime;

}
