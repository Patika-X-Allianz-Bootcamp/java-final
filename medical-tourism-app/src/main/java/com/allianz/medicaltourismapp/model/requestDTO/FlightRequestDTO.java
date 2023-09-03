package com.allianz.medicaltourismapp.model.requestDTO;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class FlightRequestDTO extends BaseDTO {
        private List<SeatRequestDTO> seats;
        private String startingTime;
        private String reactingTime;
        private String departurePlace;
        private String arrivalPlace;


}
