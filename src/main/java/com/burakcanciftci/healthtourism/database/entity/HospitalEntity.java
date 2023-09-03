package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.CompanyEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@Data
public class HospitalEntity extends CompanyEntity {
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hospital")
    Set<MedicalDepartmentEntity> departmentSet = new HashSet<>();

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "hospital_doctor",
            joinColumns = {@JoinColumn(name = "hospital_id")},
            inverseJoinColumns = {@JoinColumn(name = "doctor_id")}
    )
    Set<DoctorEntity> doctorSet = new HashSet<>();
}
