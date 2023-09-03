package com.tourismcorp.healthtourism.model.requestDTO;

import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

@Data
public class SelectFlightRequestDTO extends BaseDTO {
    private FlightRequestDTO flight;
    private SeatRequestDTO seat;
}
