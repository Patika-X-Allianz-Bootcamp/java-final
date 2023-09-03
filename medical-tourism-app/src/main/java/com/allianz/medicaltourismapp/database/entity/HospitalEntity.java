package com.allianz.medicaltourismapp.database.entity;

import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;


@Entity
@Data
@Table(name = "hospitals")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "hospital_uuid"
        )
)
public class HospitalEntity extends BaseEntity {
    @Column
    private String hospitalName;
    @Column
    private String hospitalAddress;
    @Column
    private String hospitalPhone;

    @OneToMany
    private List<DepartmentEntity> departments;
}
