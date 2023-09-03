package com.allianz.healthtourismagency.model.requestDTO;

import com.allianz.healthtourismagency.model.enums.AppointmentStatusEnum;
import com.allianz.healthtourismagency.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentStatusRequestDTO extends BaseDTO {

    private AppointmentStatusEnum appointmentStatus;

}
