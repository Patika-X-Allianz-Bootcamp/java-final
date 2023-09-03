package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "salary_uuid"
        )
)
@Data
public class SalaryEntity extends BaseEntity {
    @ToString.Exclude
    @ManyToOne
    DoctorEntity doctor;

    @Column
    BigDecimal amount;
}
