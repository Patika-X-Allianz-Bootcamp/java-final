package com.allianz.healthtourism.model.responseDTO.plainResponseDTO;

import com.allianz.healthtourism.model.responseDTO.CityResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class HospitalPlainResponseDTO extends BaseResponseDTO {
    private String name;
    private CityResponseDTO city;
}
