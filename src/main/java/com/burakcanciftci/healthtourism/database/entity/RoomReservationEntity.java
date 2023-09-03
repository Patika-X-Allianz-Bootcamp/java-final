package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;


@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "roomReservation_uuid"
        )
)
@Data
public class RoomReservationEntity extends BaseEntity {
    @JsonIgnore
    @ManyToOne
    HotelRoomEntity room;

    @JsonIgnore
    @ManyToOne
    CustomerEntity customer;

    @Column
    LocalDate startDate;

    @Column
    LocalDate endDate;

    @Column
    private BigDecimal totalPrice;
}
