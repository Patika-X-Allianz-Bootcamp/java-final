package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "seatReservation_uuid"
        )
)
@Data
public class SeatReservationEntity extends BaseEntity {
    @Column
    String code;

    @ManyToOne
    PlaneSeatEntity seat;

    @ManyToOne
    FlightEntity flight;

    @ManyToOne
    CustomerEntity customer;

    public SeatReservationEntity(){
        if(seat != null && flight != null)
            this.code = generateCode(seat.getSeatCode(), flight.getFlightCode());
    }

    public static String generateCode(String seatCode, String flightCode){
        return seatCode + flightCode;
    }
}
