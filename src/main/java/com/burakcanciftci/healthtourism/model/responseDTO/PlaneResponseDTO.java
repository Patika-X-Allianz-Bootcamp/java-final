package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class PlaneResponseDTO extends BaseDTO {
    String name;
    String planeType;
    List<FlightResponseDTO> flightList = new ArrayList<>();
    Set<PlaneSeatResponseDTO> seatSet = new HashSet<>();
}
