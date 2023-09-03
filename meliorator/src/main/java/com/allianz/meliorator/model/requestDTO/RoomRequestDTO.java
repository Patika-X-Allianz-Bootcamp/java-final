package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class RoomRequestDTO extends BaseRequestDTO {
    private Integer roomNumber;
    private BigDecimal price;
    private Boolean isReserved;
    private Date reservationDate;
}
