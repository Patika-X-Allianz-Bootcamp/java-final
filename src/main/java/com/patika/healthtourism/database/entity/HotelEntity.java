package com.patika.healthtourism.database.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.patika.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table
public class HotelEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phoneNumber;
    @Column
    private Double pricePerNight;
    @Column
    private Integer starRating;

    @Column(columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate checkInDate;

    @Column(columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate checkOutDate;
}
