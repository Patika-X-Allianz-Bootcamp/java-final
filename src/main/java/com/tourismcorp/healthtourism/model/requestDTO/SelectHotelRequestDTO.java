package com.tourismcorp.healthtourism.model.requestDTO;

import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

@Data
public class SelectHotelRequestDTO extends BaseDTO {
    private HotelRequestDTO hotel;
    private RoomRequestDTO room;
}
