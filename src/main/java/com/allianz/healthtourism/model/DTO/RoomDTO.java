package com.allianz.healthtourism.model.DTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class RoomDTO extends BaseDTO {
    private int roomNumber;
    private String roomType;
    private HotelDTO hotel;
    private List<ReservationDTO> reservations;
}