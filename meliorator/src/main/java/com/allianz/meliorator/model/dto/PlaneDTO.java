package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.database.entity.Seat;
import com.allianz.meliorator.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class PlaneDTO extends BaseDTO {
    private Seat seat;
    private String Model;
    private String CompanyName;
}
