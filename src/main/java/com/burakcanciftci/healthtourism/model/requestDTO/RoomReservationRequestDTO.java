package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class RoomReservationRequestDTO extends BaseDTO {
    private UUID travelPlanUuid;
    private HotelRoomRequestDTO room;
    private CustomerRequestDTO customer;
    private LocalDate startDate;
    private LocalDate endDate;
}
