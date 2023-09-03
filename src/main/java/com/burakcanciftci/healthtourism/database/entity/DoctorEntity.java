package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.PersonEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "doctor_uuid"
        )
)
@Data
public class DoctorEntity extends PersonEntity {
    @ToString.Exclude
    @ManyToMany(mappedBy = "doctorSet")
    Set<HospitalEntity> hospitalSet = new HashSet<>();

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "doctor_medicalDepartment",
            joinColumns = {@JoinColumn(name = "doctor_id")},
            inverseJoinColumns = {@JoinColumn(name = "medicalDepartment_id")}
    )
    Set<MedicalDepartmentEntity> medicalDepartmentSet = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    List<SalaryEntity> salaryList = new ArrayList<>();

    @Column
    List<String> workHourList = new ArrayList<>();
}
