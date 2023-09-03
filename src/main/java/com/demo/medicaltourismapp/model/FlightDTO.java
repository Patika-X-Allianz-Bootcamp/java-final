package com.demo.medicaltourismapp.model;

import com.demo.medicaltourismapp.model.enums.CityEnum;
import com.demo.medicaltourismapp.util.BaseDTO;
import lombok.Data;

@Data
public class FlightDTO extends BaseDTO {

    private int flightNo;
    private int capacity;
    private CityEnum fromCity;
    private CityEnum toCity;
}
