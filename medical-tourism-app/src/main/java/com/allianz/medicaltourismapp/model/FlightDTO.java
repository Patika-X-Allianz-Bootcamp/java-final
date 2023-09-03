package com.allianz.medicaltourismapp.model;

import com.allianz.medicaltourismapp.util.dbutil.BaseDTO;


import lombok.Data;

import java.util.List;

@Data
public class FlightDTO extends BaseDTO {
        private String flightCode;
        private List<SeatDTO> seats;
        private String startingTime;
        private String reactingTime;
        private String departurePlace;
        private String arrivalPlace;
        private String flightCompanyName;


}
