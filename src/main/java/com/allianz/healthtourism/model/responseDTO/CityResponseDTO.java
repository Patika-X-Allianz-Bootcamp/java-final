package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.util.BaseRequestDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

@Data
public class CityResponseDTO extends BaseResponseDTO {
    private String name;
    private String country;
}
