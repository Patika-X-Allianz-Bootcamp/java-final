package com.patika.healthtourism.model.requestDTO;
import com.patika.healthtourism.util.BaseDTO;
import com.patika.healthtourism.util.BaseRequestDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.Duration;

@Data
public class HealthServiceRequestDTO extends BaseRequestDTO {
    private String serviceName;
    private String description;
    private Double price;
    private Duration duration;
}
