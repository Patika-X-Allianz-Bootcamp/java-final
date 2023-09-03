package com.allianz.medicaltourismapp.model.requestDTO;

import com.allianz.medicaltourismapp.model.enums.TicketTypeEnum;
import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;

@Data
public class TicketRequestDTO extends BaseDTO {
    private TicketTypeEnum typeEnum;
    private PassengerRequestDTO passenger;
    private FlightRequestDTO flight;
    private SeatRequestDTO seat;




}
