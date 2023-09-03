package com.allianz.healthtourism.model.DTO;


import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDTO extends BaseDTO {
    private RoomDTO room;
    private PatientDTO patient;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean isPaid = false;
}