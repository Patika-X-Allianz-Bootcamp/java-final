package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class RoomReservationResponseDTO extends BaseDTO {
    private HotelRoomResponseDTO room;
    private CustomerResponseDTO customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private UUID travelPlanUuid;
}
