package com.allianz.patienttourism.model.responseDTO;

import com.allianz.patienttourism.database.entity.Room;
import com.allianz.patienttourism.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HotelResponseDTO extends BaseResponseDTO {
    private String name;
    private int starCount;
    private List<RoomResponseDTO> roomList;
}
