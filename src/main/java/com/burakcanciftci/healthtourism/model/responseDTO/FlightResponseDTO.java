package com.burakcanciftci.healthtourism.model.responseDTO;

import com.burakcanciftci.healthtourism.util.modelutil.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

@Data
public class FlightResponseDTO extends BaseDTO {
    String flightCode;
    PlaneResponseDTO plane;
    LocalDateTime departureTime;
    LocalDateTime landingTime;
    AirportResponseDTO airportFrom;
    AirportResponseDTO airportTo;
    Set<SeatReservationResponseDTO> seatReservationSet = new HashSet<>();
}
