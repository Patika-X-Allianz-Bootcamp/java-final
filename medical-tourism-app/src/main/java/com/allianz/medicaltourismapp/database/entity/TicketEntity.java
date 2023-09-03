package com.allianz.medicaltourismapp.database.entity;

import com.allianz.medicaltourismapp.model.enums.TicketTypeEnum;
import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tickets")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "ticket_uuid"
        )
)
public class TicketEntity extends BaseEntity {
    @Column
    private String ticketCode;
    @Column
    private TicketTypeEnum typeEnum;
    @ManyToOne(fetch = FetchType.LAZY)
    private PassengerEntity passenger;

    @ManyToOne(cascade = CascadeType.ALL)
    private FlightEntity flight;

    @OneToOne
    @JoinColumn(name = "seat_id", unique = true)
    private SeatEntity seat;




}
