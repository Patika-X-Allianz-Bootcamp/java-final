package com.burakcanciftci.healthtourism.model.requestDTO;

import lombok.Data;

import java.util.UUID;

@Data
public class HotelRoomPriceRequestDTO {
    private UUID roomUuid;
    private int totalDay;
}
