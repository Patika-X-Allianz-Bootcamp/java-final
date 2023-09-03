package com.healthtourism.healthtourism.database.entities;

import com.healthtourism.healthtourism.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "health_services")
@Data
public class HealthServiceEntity extends BaseEntity {

    @Column
    private String serviceName;
    @Column
    private String description;
    @Column
    private double servicePrice;


}

