package com.allianz.healthtourismagency.database.entity;

import com.allianz.healthtourismagency.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "medications")
@Data
public class MedicationEntity extends BaseEntity {

    @Column
    private String name;
    @Column
    private String dosage;

}
