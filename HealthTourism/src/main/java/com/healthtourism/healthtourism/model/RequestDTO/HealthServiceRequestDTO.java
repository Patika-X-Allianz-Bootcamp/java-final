package com.healthtourism.healthtourism.model.RequestDTO;

import com.healthtourism.healthtourism.util.BaseDTO;
import lombok.Data;

@Data
public class HealthServiceRequestDTO extends BaseDTO {
    private String serviceName;
    private String description;
    private double servicePrice;
}
