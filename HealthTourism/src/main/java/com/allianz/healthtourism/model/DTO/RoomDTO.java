package com.allianz.healthtourism.model.DTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RoomDTO extends BaseDTO {
    private int capacity;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private HotelDTO hotel;
    private List<AppointmentDTO> reservations;
}
