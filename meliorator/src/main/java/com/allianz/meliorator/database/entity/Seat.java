package com.allianz.meliorator.database.entity;

import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="seat")
@Data
public class Seat extends BaseEntity {
    @Column
    private int seatNumber;
    @Column
    private boolean isReserved;

}
