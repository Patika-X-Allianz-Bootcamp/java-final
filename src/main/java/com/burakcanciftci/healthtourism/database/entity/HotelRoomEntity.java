package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "hotelRoom_uuid"
        )
)
@Data
public class HotelRoomEntity extends BaseEntity {
    @ManyToOne
    HotelEntity hotel;

    @Column
    String doorCode;

    @Column
    String roomType;

    @Column
    BigDecimal pricePerNight;

    @Column
    List<LocalDate> availableDateList = new ArrayList<>();
}
