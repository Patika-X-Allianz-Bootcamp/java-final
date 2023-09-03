package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseRequestDTO;
import lombok.Data;

@Data
public class PlaneTicketRequestDTO extends BaseRequestDTO {
    private Long flightId;
    private Long seatId;
    private Long patientId;
}
