package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "medicalDepartment_uuid"
        )
)
@Data
public class MedicalDepartmentEntity extends BaseEntity {
    @Column(unique = true)
    String speciality;

    @ToString.Exclude
    @ManyToOne
    HospitalEntity hospital;
}
