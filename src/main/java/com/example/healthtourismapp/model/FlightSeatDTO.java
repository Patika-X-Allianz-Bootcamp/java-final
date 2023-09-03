package com.example.healthtourismapp.model;

import com.example.healthtourismapp.model.enums.FlightClassEnum;
import com.example.healthtourismapp.util.BaseDTO;
import lombok.Data;

@Data
public class FlightSeatDTO extends BaseDTO {

    private FlightClassEnum flightClass;
    private String seatNumber;
}
