package com.allianz.healthtourism.model.requestDTO;


import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationRequestDTO extends BaseDTO {
    private RoomRequestDTO room;
    private PatientRequestDTO patient;
    private LocalDateTime reservationDate;
    private boolean isPaid = false;
}
