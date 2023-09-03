package com.allianz.patienttourism.database.entity;

import com.allianz.patienttourism.model.enums.SeatType;
import com.allianz.patienttourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "seats")
@Data
public class Seat extends BaseEntity {

    @Column(name = "seatNumber")
    private String seatNumber;

    @Column(name = "seatType")
    private SeatType seatType;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @OneToMany(mappedBy = "seat")
    private List<Ticket> ticketList;

}
