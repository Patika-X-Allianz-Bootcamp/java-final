package com.allianz.healthtourismagency.database.entity;

import com.allianz.healthtourismagency.util.dbutil.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;
@Entity
@Table(name = "reservations")
@Data
public class HotelReservationEntity extends BaseEntity {

    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;

}
