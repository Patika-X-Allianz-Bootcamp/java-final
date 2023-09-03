package com.allianz.patienttourism.model.requestDTO;

import com.allianz.patienttourism.model.enums.RoomType;
import com.allianz.patienttourism.util.BaseRequestDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomRequestDTO extends BaseRequestDTO {

    private String roomNumber;


    private RoomType roomType;


    private BigDecimal price;

    private Long hotelId;
}
