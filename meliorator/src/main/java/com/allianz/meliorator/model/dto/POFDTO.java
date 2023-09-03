package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.database.entity.Flight;
import com.allianz.meliorator.model.enums.ClassTypeEnum;
import com.allianz.meliorator.util.BaseDTO;
import lombok.Data;

import java.util.List;
@Data
public class POFDTO extends BaseDTO {

    private List<Flight> flightList;
    private int bodyCount;
    private boolean isApproved;
    private ClassTypeEnum classTypeEnum;
}
