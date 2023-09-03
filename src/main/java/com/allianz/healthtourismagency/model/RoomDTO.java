package com.allianz.healthtourismagency.model;

import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RoomDTO extends BaseDTO {

    private int roomNumber;
    private List<HotelReservationDTO> reservationList = new ArrayList<>();



}
