package com.allianz.HealthTourismSpringBoot.database.entities;

import com.allianz.HealthTourismSpringBoot.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table
@Data
public class AgencyEntity extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String name;

}
