package com.demo.medicaltourismapp.database.entity;

import com.demo.medicaltourismapp.model.enums.CityEnum;
import com.demo.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "hotel_id"
        )
)
public class HotelEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private int capacity;

    @Column
    private CityEnum city;
}
