package com.allianz.medicaltourismapp.model.requestDTO;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class ReservationRequestDTO extends BaseDTO {
    private GuestRequestDTO guest;
    private String date;
    private BigDecimal price;
    private RoomRequestDTO room;
}
