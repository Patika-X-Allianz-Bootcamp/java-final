package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Table
@Entity
@Data
public class HealthCareServiceEntity extends BaseEntity {
    private String name;
    private BigDecimal price;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<HospitalEntity> hospitals;
}
