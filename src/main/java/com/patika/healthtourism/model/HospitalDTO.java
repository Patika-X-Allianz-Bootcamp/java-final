package com.patika.healthtourism.model;

import com.patika.healthtourism.database.entity.HealthServiceEntity;
import com.patika.healthtourism.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

@Data
public class HospitalDTO extends BaseDTO {
    private String name;
    private String address;
    private String phoneNumber;
    private String websiteUrl;
    private Set<HealthServiceDTO> healthServices;
}
