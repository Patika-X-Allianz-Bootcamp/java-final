package com.demo.medicaltourismapp.model.requestDTO;

import com.demo.medicaltourismapp.model.enums.CityEnum;
import com.demo.medicaltourismapp.util.BaseDTO;
import lombok.Data;

@Data
public class FlightRequestDTO extends BaseDTO {

    private int flightNo;
    private int capacity;
    private CityEnum fromCity;
    private CityEnum toCity;
}
