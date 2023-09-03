package com.allianz.medicaltourismapp.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "guests")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "guest_uuid"
        )
)
public class GuestEntity extends PersonEntity {

        @OneToMany
        private List<CreditCardEntity> creditCards;

        @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
        private List<ReservationEntity> reservations;
}
