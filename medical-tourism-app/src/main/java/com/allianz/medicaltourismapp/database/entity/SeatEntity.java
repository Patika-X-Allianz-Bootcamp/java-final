package com.allianz.medicaltourismapp.database.entity;

import com.allianz.medicaltourismapp.model.enums.BookingStatusEnum;
import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "seats")
public class SeatEntity extends BaseEntity {
    @ManyToOne
    private FlightEntity flight;
    @Column
    private String seatCode;
    @Column
    private BookingStatusEnum bookingStatusEnum;


}
