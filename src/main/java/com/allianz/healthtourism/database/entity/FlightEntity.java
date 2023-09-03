package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Table
@Entity
@Data
public class FlightEntity extends BaseEntity {
    private BigDecimal price;
    @Column(name = "flight_date")
    private LocalDateTime flightDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_to_id")
    private CityEntity cityTo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_from_id")
    private CityEntity cityFrom;
    @ManyToOne(fetch = FetchType.LAZY)
    private PlaneEntity plane;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PatientEntity> patients;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SeatEntity> seats;
}
