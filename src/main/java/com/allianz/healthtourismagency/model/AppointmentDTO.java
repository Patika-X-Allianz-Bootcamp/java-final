package com.allianz.healthtourismagency.model;

import com.allianz.healthtourismagency.model.enums.AppointmentStatusEnum;
import com.allianz.healthtourismagency.util.BaseDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentDTO extends BaseDTO {

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private AppointmentStatusEnum appointmentStatus;

}
