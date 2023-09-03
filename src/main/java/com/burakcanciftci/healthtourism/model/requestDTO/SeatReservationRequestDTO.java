package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class SeatReservationRequestDTO extends BaseDTO {
    private UUID travelPlanUuid;
    private PlaneSeatRequestDTO seat;
    private FlightRequestDTO flight;
    private CustomerRequestDTO customer;
}
