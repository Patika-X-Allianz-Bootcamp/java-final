package com.tourismcorp.healthtourism.database.entities;

import com.tourismcorp.healthtourism.util.BaseEntity;
import com.tourismcorp.healthtourism.util.FlightIdGenerator;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.id.OptimizableGenerator;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table
@Entity
@Data
public class FlightEntity extends BaseEntity {

    @Column(unique = true)
    @JdbcTypeCode(Types.VARCHAR)
    private String flightNumber;
    @Column
    private String departure;
    @Column
    private String arrival;
    @Column
    private String departureTime;
    @Column
    private Date date;
    @Column
    private BigDecimal price;

    @OneToMany
    @JoinColumn(name = "flight_entity_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private List<SeatEntity> seat;

    @Override
    protected void onCreate() {
        super.onCreate();
        setFlightNumber(FlightIdGenerator.getFlightNumber());
    }

}
