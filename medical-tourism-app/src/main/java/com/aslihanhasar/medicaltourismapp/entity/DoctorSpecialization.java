package com.aslihanhasar.medicaltourismapp.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "specializations")
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "specialization_id"
        )
)
public class DoctorSpecialization extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String departmentCode;
}
