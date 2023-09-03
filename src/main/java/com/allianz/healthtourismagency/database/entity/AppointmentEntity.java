package com.allianz.healthtourismagency.database.entity;

import com.allianz.healthtourismagency.model.enums.AppointmentStatusEnum;
import com.allianz.healthtourismagency.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Data
public class AppointmentEntity extends BaseEntity {

    @Temporal(TemporalType.DATE)
    private LocalDate date;
    @Temporal(TemporalType.TIME)
    private LocalTime startTime;
    @Temporal(TemporalType.TIME)
    private LocalTime endTime;
    @Enumerated(EnumType.STRING)
    private AppointmentStatusEnum appointmentStatus;

}
