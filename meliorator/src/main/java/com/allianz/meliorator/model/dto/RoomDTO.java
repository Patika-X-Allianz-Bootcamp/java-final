package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.util.BaseDTO;
import jakarta.persistence.Column;
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
