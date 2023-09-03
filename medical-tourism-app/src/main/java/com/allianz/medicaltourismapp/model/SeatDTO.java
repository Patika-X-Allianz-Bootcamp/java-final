package com.allianz.medicaltourismapp.model;
import com.allianz.medicaltourismapp.model.enums.BookingStatusEnum;
import com.allianz.medicaltourismapp.model.enums.TicketTypeEnum;
import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;

@Data

public class SeatDTO extends BaseDTO {
    private String seatCode;
    private BookingStatusEnum bookingStatusEnum;
    private FlightDTO flight;

}
