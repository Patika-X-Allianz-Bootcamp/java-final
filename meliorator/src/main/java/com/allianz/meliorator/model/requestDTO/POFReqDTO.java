package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.database.entity.Flight;
import com.allianz.meliorator.model.enums.ClassTypeEnum;
import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;

import java.util.List;
@Data
public class POFReqDTO extends BaseRequestDTO {

    private List<Flight> flightList;
    private int bodyCount;
    private boolean isApproved;
    private ClassTypeEnum classTypeEnum;
}
