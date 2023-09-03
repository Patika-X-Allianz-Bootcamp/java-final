package com.allianz.healthtourism.model.requestDTO;

import com.allianz.healthtourism.util.BaseRequestDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class HealthCareServiceRequestDTO extends BaseRequestDTO {
    private String name;
    private BigDecimal price;
}
