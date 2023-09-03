package com.demo.medicaltourismapp.model;

import com.demo.medicaltourismapp.database.entity.DoctorEntity;
import com.demo.medicaltourismapp.model.enums.CityEnum;
import com.demo.medicaltourismapp.util.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class HospitalDTO extends BaseDTO {

    private String name;
    private CityEnum city;
    @JsonIgnore
    private List<DoctorEntity> doctorList;
}
