package com.tourismcorp.healthtourism.database.entities;

import com.tourismcorp.healthtourism.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Table
@Entity
public class RoomEntity extends BaseEntity {
    @Column
    private Integer roomNumber;

    @Column
    private BigDecimal price;

    @Column
    private Boolean isReserved;

    @Column
    private Date reservationDate;


    /*
    @PreUpdate
    public void preUpdate() {
        if (exitDate != null) {
            isReserved = true; // exitDate atanıyorsa isReserved true olmalı
        }
    }*/
}
