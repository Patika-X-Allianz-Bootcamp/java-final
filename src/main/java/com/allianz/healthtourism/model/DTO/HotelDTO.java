package com.allianz.healthtourism.model.DTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class HotelDTO extends BaseDTO {
    private String name;
    private String city;
    private List<RoomDTO> rooms;
}