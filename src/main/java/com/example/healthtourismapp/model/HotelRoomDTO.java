package com.example.healthtourismapp.model;

import com.example.healthtourismapp.model.enums.RoomTypeEnum;
import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;

@Data
public class HotelRoomDTO extends BaseDTO {

    private String roomNumber;
    private RoomTypeEnum roomType;
}
