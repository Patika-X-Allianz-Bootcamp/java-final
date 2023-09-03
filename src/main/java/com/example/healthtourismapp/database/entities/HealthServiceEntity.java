package com.example.healthtourismapp.database.entities;

import com.example.healthtourismapp.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table
@Data
public class HealthServiceEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String serviceName;

    @OneToMany
    private List<DoctorEntity> doctorList;

}
