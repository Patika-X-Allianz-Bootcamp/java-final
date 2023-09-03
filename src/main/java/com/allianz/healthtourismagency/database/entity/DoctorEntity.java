package com.allianz.healthtourismagency.database.entity;

import com.allianz.healthtourismagency.model.enums.HospitalDepartmentEnum;
import com.allianz.healthtourismagency.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "doctors")
@Data
public class DoctorEntity extends BaseEntity {

    @Column
    private String name;
    @Column
    private String workEmail;

    @Column
    private String workPhoneNumber;

    @Column
    private String identityNumber;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private HospitalDepartmentEnum hospitalDepartment;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AppointmentEntity> appointmentList;


}
