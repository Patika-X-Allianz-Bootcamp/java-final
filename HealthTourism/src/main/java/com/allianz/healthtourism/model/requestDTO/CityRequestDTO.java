package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CityRequestDTO extends BaseDTO {

    private String name;

    private List<HospitalRequestDTO> hospitalList;


}
