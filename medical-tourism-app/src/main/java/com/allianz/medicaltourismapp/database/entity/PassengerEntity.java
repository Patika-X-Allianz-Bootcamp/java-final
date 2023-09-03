package com.allianz.medicaltourismapp.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "passengers")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "passenger_uuid"
        )
)
public class PassengerEntity extends PersonEntity {


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<TicketEntity> ticket;

    @OneToMany
    private List<CreditCardEntity> creditCards;

}
