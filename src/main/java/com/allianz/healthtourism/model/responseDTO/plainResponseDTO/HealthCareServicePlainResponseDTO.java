package com.allianz.healthtourism.model.responseDTO.plainResponseDTO;

import com.allianz.healthtourism.util.BaseResponseDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class HealthCareServicePlainResponseDTO extends BaseResponseDTO {
    private String name;
    private BigDecimal price;
}
