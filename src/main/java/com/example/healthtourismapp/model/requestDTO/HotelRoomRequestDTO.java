package com.example.healthtourismapp.model.requestDTO;

import com.example.healthtourismapp.model.enums.RoomTypeEnum;
import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;

@Data
public class HotelRoomRequestDTO extends BaseDTO {

    private String roomNumber;
    private RoomTypeEnum roomType;
}
