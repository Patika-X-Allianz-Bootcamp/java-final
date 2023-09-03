package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.database.entity.City;
import com.allianz.meliorator.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CountryDTO extends BaseDTO {
    private String name;
    private List<City> city;
}
