package com.allianz.meliorator.database.entity;

import com.allianz.meliorator.util_db.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table
@Data
public class Room extends BaseEntity {
    @Column
    private Integer roomNumber;

    @Column
    private BigDecimal price;

    @Column
    private Boolean isReserved;

    @Column
    private Date reservationDate;
}
