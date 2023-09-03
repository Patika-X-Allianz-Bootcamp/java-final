package com.tourismcorp.healthtourism.model;

import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RoomDTO extends BaseDTO {

    private Integer roomNumber;

    private BigDecimal price;

    private Boolean isReserved;

    private Date reservationDate;
}
