package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "flight_uuid"
        )
)
@Data
public class FlightEntity extends BaseEntity {
    @Column(unique = true)
    String flightCode;

    @ManyToOne
    PlaneEntity plane;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime departureTime;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime landingTime;

    @ManyToOne
    AirportEntity airportFrom;

    @ManyToOne
    AirportEntity airportTo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight")
    Set<SeatReservationEntity> seatReservationSet = new HashSet<>();
}
