package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.database.entity.ReservationEntity;
import com.allianz.healthtourism.model.DTO.HotelDTO;
import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RoomRequestDTO extends BaseDTO {
    private int capacity;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private HotelDTO hotel;
    private List<ReservationEntity> reservations;
}