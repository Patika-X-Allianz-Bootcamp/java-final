package com.demo.medicaltourismapp.database.entity;

import com.demo.medicaltourismapp.model.enums.DoctorSpecialtyEnum;
import com.demo.medicaltourismapp.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
@AttributeOverride(
        name = "id",
        column = @Column(
                name = "doctor_id"
        )
)
public class DoctorEntity extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", nullable = false)
    private HospitalEntity hospital;

    @Column
    private DoctorSpecialtyEnum doctorSpecialtyEnum;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AppointmentEntity> appointmentList;

}
