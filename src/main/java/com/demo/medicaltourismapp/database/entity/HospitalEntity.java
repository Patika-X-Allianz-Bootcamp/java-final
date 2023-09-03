package com.demo.medicaltourismapp.database.entity;

import com.demo.medicaltourismapp.model.enums.CityEnum;
import com.demo.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "hospital_id"
        )
)
public class HospitalEntity extends BaseEntity {

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<DoctorEntity> doctorList;

    @Column
    private CityEnum city;

}
