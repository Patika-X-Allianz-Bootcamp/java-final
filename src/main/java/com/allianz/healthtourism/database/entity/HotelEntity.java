package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Table
@Entity
@Data
public class HotelEntity extends BaseEntity {
    private String name;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private CityEntity city;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PatientEntity> patients;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<RoomEntity> rooms;
}
