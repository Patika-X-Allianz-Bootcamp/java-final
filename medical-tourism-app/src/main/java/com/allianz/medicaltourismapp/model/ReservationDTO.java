package com.allianz.medicaltourismapp.model;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class ReservationDTO extends BaseDTO {
    private String ReservationCode;
    private GuestDTO guest;
    private String date;
    private BigDecimal price;
    private RoomDTO roomNumber;
}
