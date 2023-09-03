package com.allianz.medicaltourismapp.database.entity;

import com.allianz.medicaltourismapp.model.enums.BookingStatusEnum;
import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "rooms")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "room_uuid"
        )
)
public class RoomEntity extends BaseEntity {
        @ManyToOne
        private HotelEntity hotel;
        @Column
        private int roomNumber;
        @Column
        private BookingStatusEnum bookingStatusEnum;
}
