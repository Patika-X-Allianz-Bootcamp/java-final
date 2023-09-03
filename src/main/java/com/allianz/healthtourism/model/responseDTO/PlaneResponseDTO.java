package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class PlaneResponseDTO extends BaseResponseDTO {
    private String name;
    private int seatCount;
    private CityResponseDTO city;
}
