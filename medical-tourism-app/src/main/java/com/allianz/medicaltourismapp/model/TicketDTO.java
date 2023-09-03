package com.allianz.medicaltourismapp.model;

import com.allianz.medicaltourismapp.model.enums.TicketTypeEnum;
import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;


import lombok.Data;

@Data
public class TicketDTO extends BaseDTO {
    private String ticketCode;
    private TicketTypeEnum typeEnum;
    private PassengerDTO passenger;
    private FlightDTO flightCode;
    private SeatDTO seatCode;




}
