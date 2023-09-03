package com.burakcanciftci.healthtourism.database.entity;

import com.burakcanciftci.healthtourism.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "examination_uuid"
        )
)
@Data
public class ExaminationEntity extends BaseEntity {
    @Column
    String code;

    @ManyToOne
    CustomerEntity customer;

    @ToString.Exclude
    @ManyToOne
    DoctorEntity doctor;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime examinationTime;

    @OneToOne
    ExaminationCardEntity examinationCard;

    @ManyToOne
    HospitalEntity hospital;

    @ManyToOne
    MedicalDepartmentEntity medicalDepartment;

    public ExaminationEntity(){
        if(doctor != null && examinationTime != null)
            this.code = generateCode(doctor.getName(), examinationTime.toString());
    }

    public static String generateCode(String doctorName, String examinationTime){
        return doctorName + examinationTime;
    }
}
