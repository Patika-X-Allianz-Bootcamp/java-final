package com.allianz.healthtourism.model.responseDTO;

import com.allianz.healthtourism.model.responseDTO.plainResponseDTO.HospitalPlainResponseDTO;
import com.allianz.healthtourism.util.BaseResponseDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class HealthCareServiceResponseDTO extends BaseResponseDTO {
    private String name;
    private BigDecimal price;
    private List<HospitalPlainResponseDTO> hospitals;
}
