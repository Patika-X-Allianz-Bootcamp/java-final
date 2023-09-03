package com.allianz.healthtourismagency.database.entity;

import com.allianz.healthtourismagency.model.enums.FlightTypeEnum;
import com.allianz.healthtourismagency.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "travelPlan")
@Data
public class TravelPlanEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    public FlightTypeEnum flightType;
    @ManyToMany(fetch = FetchType.LAZY)
    public List<FlightEntity> flightList;
    @OneToMany(fetch = FetchType.LAZY)
    public List<SeatEntity> seatList;
    @ManyToOne(fetch = FetchType.LAZY)
    public HotelEntity hotel;
    @ManyToOne(fetch = FetchType.LAZY)
    public RoomEntity room;

}
