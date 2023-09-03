package com.demo.medicaltourismapp.database.entity;

import com.demo.medicaltourismapp.model.enums.CityEnum;
import com.demo.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "flight_id"
        )
)
public class FlightEntity extends BaseEntity {

    @Column
    private int flightNo;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private CityEnum fromCity;

    @Column(nullable = false)
    private CityEnum toCity;
}
