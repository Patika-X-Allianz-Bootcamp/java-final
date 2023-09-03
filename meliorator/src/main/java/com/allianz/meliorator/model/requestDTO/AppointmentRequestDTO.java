package com.allianz.meliorator.model.requestDTO;

import com.allianz.meliorator.database.entity.Doctor;
import com.allianz.meliorator.database.entity.Patient;
import com.allianz.meliorator.util.BaseDTO;
import com.allianz.meliorator.util.BaseRequestDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequestDTO extends BaseRequestDTO {
    private Patient patient;

    private Doctor doctor;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private boolean isApproved;

    private String report;


}
