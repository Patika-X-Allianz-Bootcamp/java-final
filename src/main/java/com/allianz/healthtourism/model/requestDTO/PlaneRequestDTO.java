package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class PlaneRequestDTO extends BaseRequestDTO {
    private String name;
    private int seatCount;
    private Long cityId;
}
