package com.example.healthtourismapp.model.requestDTO;

import com.example.healthtourismapp.model.FlightSeatDTO;
import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class FlightRequestDTO extends BaseDTO {

    private String flightCode;
    private String fromWhere;
    private String toWhere;
    private Date Date;
    private double distance;
    private List<FlightSeatDTO> seat;
}
