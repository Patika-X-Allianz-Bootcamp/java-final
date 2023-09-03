package com.example.healthtourismapp.model.requestDTO;

import com.example.healthtourismapp.model.HotelRoomDTO;
import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HotelRequestDTO extends BaseDTO {

    private String name;
    private String numberOfStars;
    private List<HotelRoomDTO> hotelRoomList;
}
