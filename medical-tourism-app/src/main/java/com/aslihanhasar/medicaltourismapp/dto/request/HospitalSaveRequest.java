package com.aslihanhasar.medicaltourismapp.dto.request;

import com.aslihanhasar.medicaltourismapp.entity.City;
import com.aslihanhasar.medicaltourismapp.entity.Doctor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalSaveRequest {
    @NotBlank
    private String hospitalName;
    @NotBlank
    private String hospitalCode;
    @NotBlank
    private Long cityId;
}
