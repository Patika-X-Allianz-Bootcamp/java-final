package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

@Data
public class TravelPlanRequestDTO extends BaseDTO {
    private CustomerRequestDTO customer;
    private ExaminationRequestDTO examination;
    private RoomReservationRequestDTO roomReservation;
    private SeatReservationRequestDTO seatReservation;
}
