package com.allianz.medicaltourismapp.database.entity;

import com.allianz.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "departments")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "department_uuid"
        )
)
public class DepartmentEntity extends BaseEntity {
    @OneToMany
    private List<DoctorEntity> doctors;

    @Column
    private String departmentName;
}
