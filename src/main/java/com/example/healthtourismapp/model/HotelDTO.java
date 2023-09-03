package com.example.healthtourismapp.model;

import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;
import java.util.List;

@Data
public class HotelDTO extends BaseDTO {

    private String name;
    private String numberOfStars;
    private List<HotelRoomDTO> hotelRoomList;
}
