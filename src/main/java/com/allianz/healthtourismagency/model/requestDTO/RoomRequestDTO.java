package com.allianz.healthtourismagency.model.requestDTO;

import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoomRequestDTO extends BaseDTO {

    private int roomNumber;
    private List<HotelReservationRequestDTO> reservationList = new ArrayList<>();



}
