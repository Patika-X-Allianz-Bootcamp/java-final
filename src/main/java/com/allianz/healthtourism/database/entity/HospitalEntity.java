package com.allianz.healthtourism.database.entity;

import com.allianz.healthtourism.util.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "hospitals")

public class HospitalEntity extends BaseEntity {
    private String name;
    private String address;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private Set<DoctorEntity> doctors;
}
