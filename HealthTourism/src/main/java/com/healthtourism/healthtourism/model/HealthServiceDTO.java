package com.healthtourism.healthtourism.model;

import com.healthtourism.healthtourism.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class HealthServiceDTO extends BaseDTO {
    private String serviceName;
    private String description;
    private double servicePrice;
}
