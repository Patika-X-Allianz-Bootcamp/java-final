package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class PlaneRequestDTO extends BaseDTO {
    String name;
    String planeType;
    @JsonIgnore
    List<FlightRequestDTO> flightList = new ArrayList<>();
    @JsonIgnore
    Set<PlaneSeatRequestDTO> seatSet = new HashSet<>();
}
