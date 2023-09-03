package com.allianz.patienttourism.database.entity;

import com.allianz.patienttourism.model.enums.RoomType;
import com.allianz.patienttourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "rooms")
@Data
public class Room extends BaseEntity {

    @Column(name = "roomNumber")
    private String roomNumber;

    @Column(name = "roomType")
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookingList;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}
