package com.burakcanciftci.healthtourism.model.requestDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class FlightRequestDTO extends BaseDTO {
    String flightCode;
    PlaneRequestDTO plane;
    LocalDateTime departureTime;
    LocalDateTime landingTime;
    AirportRequestDTO airportFrom;
    AirportRequestDTO airportTo;
    Set<SeatReservationRequestDTO> seatReservationSet = new HashSet<>();
}
