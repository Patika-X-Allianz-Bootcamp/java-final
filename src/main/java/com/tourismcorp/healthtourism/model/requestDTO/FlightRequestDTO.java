package com.tourismcorp.healthtourism.model.requestDTO;

import com.tourismcorp.healthtourism.model.SeatDTO;
import com.tourismcorp.healthtourism.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
public class FlightRequestDTO extends BaseDTO {

    private String flightNumber;
    private String departure;
    private String arrival;
    private String departureTime;
    private Date date;
    private BigDecimal price;
    private List<SeatRequestDTO> seat;
}
