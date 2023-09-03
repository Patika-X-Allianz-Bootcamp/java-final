package com.demo.medicaltourismapp.model;

import com.demo.medicaltourismapp.database.entity.AppointmentEntity;
import com.demo.medicaltourismapp.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class PatientDTO extends BaseDTO {

    private String name;
    @JsonIgnore
    private List<AppointmentEntity> appointmentList;
    private boolean isSessionActive;
}
