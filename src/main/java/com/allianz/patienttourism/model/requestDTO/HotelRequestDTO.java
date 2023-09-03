package com.allianz.patienttourism.model.requestDTO;

import com.allianz.patienttourism.util.BaseRequestDTO;
import lombok.Data;

@Data
public class HotelRequestDTO extends BaseRequestDTO {

    private String name;
    private int starCount;
}
