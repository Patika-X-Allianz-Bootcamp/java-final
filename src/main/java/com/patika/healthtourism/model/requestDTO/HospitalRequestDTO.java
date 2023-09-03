package com.patika.healthtourism.model.requestDTO;
import com.patika.healthtourism.util.BaseRequestDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class HospitalRequestDTO extends BaseRequestDTO {
    private String name;
    private String address;
    private String phoneNumber;
    private String websiteUrl;
}
