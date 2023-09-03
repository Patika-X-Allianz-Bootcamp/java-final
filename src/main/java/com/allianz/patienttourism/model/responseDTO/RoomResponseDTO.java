package com.allianz.patienttourism.model.responseDTO;

import com.allianz.patienttourism.database.entity.Booking;
import com.allianz.patienttourism.model.enums.RoomType;
import com.allianz.patienttourism.util.BaseResponseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RoomResponseDTO extends BaseResponseDTO {

    private String roomNumber;

    private RoomType roomType;

    private BigDecimal price;

    private Long hotelId;

    private List<BookingResponseDTO> bookingList;
}
