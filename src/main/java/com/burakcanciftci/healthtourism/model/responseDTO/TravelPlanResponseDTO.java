package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

@Data
public class TravelPlanResponseDTO extends BaseDTO {
    private CustomerResponseDTO customer;
    private ExaminationResponseDTO examination;
    private RoomReservationResponseDTO roomReservation;
    private SeatReservationResponseDTO seatReservation;
}
