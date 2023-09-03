package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "travelPlan_uuid"
        )
)
@Data
public class TravelPlanEntity extends BaseEntity {
    @ManyToOne
    private CustomerEntity customer;

    @OneToOne
    private ExaminationEntity examination;

    @OneToOne
    private RoomReservationEntity roomReservation;

    @OneToOne
    private SeatReservationEntity seatReservation;
}
