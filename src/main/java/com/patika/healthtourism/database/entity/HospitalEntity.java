package com.patika.healthtourism.database.entity;

import com.patika.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table
public class HospitalEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phoneNumber;
    @Column
    private String websiteUrl;

    @OneToMany(mappedBy = "hospital",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<HealthServiceEntity> healthServices;

    @OneToMany(mappedBy = "hospital",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<AppointmentEntity> appointments;
}
