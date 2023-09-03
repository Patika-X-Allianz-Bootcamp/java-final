package com.aslihanhasar.medicaltourismapp.entity;

import com.aslihanhasar.medicaltourismapp.enums.HotelStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "hotels")
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "hotel_id"
        )
)
public class Hotel extends BaseEntity {
    @Column(unique = true)
    private String reservationNumber;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String hotelCode;
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
    @Column(nullable = false)
    private int roomCount; //all rooms are single occupancy
    @Column(nullable = false)
    private int totalCapacity;
    @Column(nullable = false)
    private BigDecimal hotelPricePerNight;
    @Enumerated(EnumType.STRING)
    private HotelStatus hotelStatus;
    private int remainingCapacity;
    private int remainingRooms;
}
