package com.allianz.healthtourism.model.responseDTO.plainResponseDTO;

import com.allianz.healthtourism.util.BaseResponseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class HotelPlainResponseDTO extends BaseResponseDTO {
    private String name;
    private BigDecimal price;
}
