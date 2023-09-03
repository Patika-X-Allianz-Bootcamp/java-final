package com.demo.medicaltourismapp.model.requestDTO;

import com.demo.medicaltourismapp.model.enums.CityEnum;
import com.demo.medicaltourismapp.util.BaseDTO;
import lombok.Data;

@Data
public class HotelRequestDTO extends BaseDTO {

    private String name;
    private int capacity;
    private CityEnum city;
}
