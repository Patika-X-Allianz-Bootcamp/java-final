package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class CityEntity extends BaseEntity {

    @Column
    private String name;

    @OneToMany(mappedBy = "city")
    private List<HospitalEntity> hospitalList;


}