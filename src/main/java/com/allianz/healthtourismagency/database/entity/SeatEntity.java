package com.allianz.healthtourismagency.database.entity;

import com.allianz.healthtourismagency.model.enums.OccupancyStatusEnum;
import com.allianz.healthtourismagency.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "seats")
@Data
public class SeatEntity extends BaseEntity {

    @Column
    private int seatNumber;
    @Enumerated(EnumType.STRING)
    private OccupancyStatusEnum occupancyStatus;

}
