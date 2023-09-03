package com.allianz.medicaltourismapp.database.entity;

import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "flights")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "flight_uuid"
        )
)
public class FlightEntity extends BaseEntity {
        @Column
        private String flightCode;
        @OneToMany
        private List<SeatEntity> seats;
        @Column
        private String startingTime;
        @Column
        private String reactingTime;
        @Column
        private String departurePlace;
        @Column
        private String arrivalPlace;


}
