package com.example.healthtourismapp.model.requestDTO;

import com.example.healthtourismapp.model.enums.FlightClassEnum;
import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;

@Data
public class FlightSeatRequestDTO extends BaseDTO {

    private FlightClassEnum flightClass;
    private String seatNumber;
}
