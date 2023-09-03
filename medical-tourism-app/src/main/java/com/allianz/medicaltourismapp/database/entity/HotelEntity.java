package com.allianz.medicaltourismapp.database.entity;

import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "hotels")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "hotel_uuid"
        )
)
public class HotelEntity extends BaseEntity {
    @Column
    private String hotelName;
    @OneToMany
    private List<RoomEntity> hotelCapacity;
    @Column
    private String hotelAdress;

}
