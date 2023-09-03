package com.allianz.medicaltourismapp.model.requestDTO;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;

import java.util.List;

@Data

public class HotelRequestDTO extends BaseDTO {
    private String hotelName;
    private List<RoomRequestDTO> hotelCapacity;
    private String hotelAdress;

}
