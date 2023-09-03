package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity
@Data
public class CityEntity extends BaseEntity {
    private String name;
    private String country;
}
