package com.allianz.medicaltourismapp.database.entity;

import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "reservations")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "resevation_uuid"
        )
)
public class ReservationEntity extends BaseEntity {

    @OneToOne
    private GuestEntity guest;
    @Column
    private String reservationCode;
    @Column
    private String date;
    @Column
    private BigDecimal price;
    @OneToOne
    private RoomEntity room;
}
