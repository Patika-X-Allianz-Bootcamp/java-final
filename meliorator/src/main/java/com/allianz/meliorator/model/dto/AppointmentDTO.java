package com.allianz.meliorator.model.dto;

import com.allianz.meliorator.database.entity.Doctor;
import com.allianz.meliorator.database.entity.Patient;
import com.allianz.meliorator.model.enums.AppointmentStatusTypeEnum;
import com.allianz.meliorator.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO extends BaseDTO {
    private Patient patient;

    private Doctor doctor;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private boolean isApproved;

    private String report;


}
