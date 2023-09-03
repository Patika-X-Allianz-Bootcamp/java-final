package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class SeatReservationResponseDTO extends BaseDTO {
    private PlaneSeatResponseDTO seat;
    private FlightResponseDTO flight;
    private CustomerResponseDTO customer;
    private UUID travelPlanUuid;
}
