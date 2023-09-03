package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.database.entity.Seat;
import com.allianz.meliorator.util.BaseDTO;
import com.allianz.meliorator.util.BaseRequestDTO;

public class PlaneRequestDTO extends BaseRequestDTO {
    private Seat seat;
    private String Model;
    private String CompanyName;
}
